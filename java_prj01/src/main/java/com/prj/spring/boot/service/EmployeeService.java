package com.prj.spring.boot.service;

import java.util.List;

import com.prj.spring.boot.domain.Employee;

public interface EmployeeService {
	/**
	 * 保存用户
	 * @param employee
	 * @return
	 */
	Employee save(Employee employee);
	/**
	 * 删除用户
	 * @param id
	 */
	void removeEmployee(Long id);
	/**
	 * 删除列表中的用户
	 * @param employee
	 */
	void removeEmployeeInBatch(List<Employee> employee);
	/**
	 * 更新用户
	 * @param employee
	 */
	void updateEmployee(Employee employee);
	/**
	 * 更近ID获取用户
	 * @param id
	 * @return
	 */
	Employee getEmployeeById(Long id);
	/**
	 * 获取用户列表
	 * @return
	 */
	List<Employee> listEmployee();
}
