package com.prj.spring.boot.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.prj.spring.boot.domain.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {


	/**
	 * 根据用户名分页查询用户列表
	 * @param name
	 * @param pageable
	 * @return
	 */
	Page<Employee> findByEmployeeNameLike(String employeeName, Pageable pageable);
	/**
	 * 根据名称查询
	 * @param username
	 * @return
	 */
	Employee findByEmployeeName(String employeeName);
	/**
	 * 根据名称列表查询
	 * @param usernames
	 * @return
	 */
	List<Employee> findByEmployeeNameIn(Collection<String> employeeName);
}
