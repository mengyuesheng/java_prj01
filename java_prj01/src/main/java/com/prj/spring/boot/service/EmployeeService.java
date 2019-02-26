package com.prj.spring.boot.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.prj.spring.boot.domain.Employee;

public interface EmployeeService {
	/**
	 * �����û�
	 * @param employee
	 * @return
	 */
	Employee save(Employee employee);
	/**
	 * ɾ���û�
	 * @param id
	 */
	void removeEmployee(Long id);
	/**
	 * ɾ���б��е��û�
	 * @param employee
	 */
	void removeEmployeeInBatch(List<Employee> employee);
	/**
	 * �����û�
	 * @param employee
	 */
	void updateEmployee(Employee employee);
	/**
	 * ����ID��ȡ�û�
	 * @param id
	 * @return
	 */
	Employee getEmployeeById(Long id);
	/**
	 * ��ȡ�û��б�
	 * @return
	 */
	List<Employee> listEmployee();
	
	/**
	 * 根据用户名进行分页模糊查询
	 * @param name
	 * @param pageable
	 * @return
	 */
	Page<Employee> listUsersByNameLike(String name, Pageable pageable);
}
