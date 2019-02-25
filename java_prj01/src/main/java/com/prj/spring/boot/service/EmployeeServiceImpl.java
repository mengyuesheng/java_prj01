package com.prj.spring.boot.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.prj.spring.boot.domain.Employee;
import com.prj.spring.boot.repository.EmployeeRepository;

public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Transactional
	@Override
	public Employee save(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	@Transactional
	@Override
	public void removeEmployee(Long id) {
		employeeRepository.delete(id);
	}
	
	@Transactional
	@Override
	public void removeEmployeeInBatch(List<Employee> employee) {
		employeeRepository.deleteInBatch(employee);
	}

	@Transactional
	@Override
	public void updateEmployee(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
	public Employee getEmployeeById(Long id) {
		return employeeRepository.findOne(id);
	}

	@Override
	public List<Employee> listEmployee() {
		return employeeRepository.findAll();
	}

}
