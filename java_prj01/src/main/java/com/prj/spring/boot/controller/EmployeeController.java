package com.prj.spring.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.prj.spring.boot.domain.Employee;
import com.prj.spring.boot.service.EmployeeService;

@RestController
@RequestMapping("/users")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/add")
	public ModelAndView addEmployee(Model model) {
		model.addAttribute("employee", new Employee(null,true,null,null,null,null,null,true));
	}
}
