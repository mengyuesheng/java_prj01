package com.prj.spring.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prj.spring.boot.domain.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	
}
