package com.prj.spring.boot.controller;

import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.prj.spring.boot.domain.Employee;
import com.prj.spring.boot.service.EmployeeService;
import com.prj.spring.boot.util.ConstraintViolationExceptionHandler;
import com.prj.spring.boot.vo.Response;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	/**
	 * required=false 参数可以不传入，默认为true参数必须传入
	 * 查询所用用户
	 * @return
	 */
	@GetMapping
	public ModelAndView list(@RequestParam(value="async",required=false) boolean async,
			@RequestParam(value="pageIndex",required=false,defaultValue="0") int pageIndex,
			@RequestParam(value="pageSize",required=false,defaultValue="10") int pageSize,
			@RequestParam(value="employeeName",required=false,defaultValue="") String employeeName,
			Model model) {
	 
		Pageable pageable = new PageRequest(pageIndex, pageSize);
		Page<Employee> page = employeeService.listUsersByNameLike(employeeName, pageable);
		List<Employee> list = page.getContent();	// 当前所在页面数据列表
		
		model.addAttribute("page", page);
		model.addAttribute("userList", list);
		//async=false
		return new ModelAndView(async==true?"users/list :: #mainContainerRepleace":"users/list", "userModel", model);
	}

	
	@GetMapping("/add")
	public ModelAndView addEmployee(Model model) {
		model.addAttribute("employee", new Employee(null,true,null,null,null,null,null,true));
		return new ModelAndView("register","employeeModel",model);
	}
	@PostMapping
	public ResponseEntity<Response> create(Employee em, Long id) {
		//判断是新增还是修改
		if(em.getEmployeeID() == null){
			em.setEncodePassword(em.getPassword());
		}else{
			Employee originaE = employeeService.getEmployeeById(em.getEmployeeID());
			String rawPassword = originaE.getPassword();
			PasswordEncoder  encoder = new BCryptPasswordEncoder();
			String encodePasswd = encoder.encode(em.getPassword());
			boolean isMatch = encoder.matches(rawPassword, encodePasswd);
			if (!isMatch) {
				em.setEncodePassword(em.getPassword());
			}else {
				em.setPassword(em.getPassword());
			}
		}
		try {
			employeeService.save(em);
		}  catch (ConstraintViolationException e)  {
			return ResponseEntity.ok().body(new Response(false, ConstraintViolationExceptionHandler.getMessage(e)));
		}
		
		return ResponseEntity.ok().body(new Response(true, "处理成功", em));
	}
}
