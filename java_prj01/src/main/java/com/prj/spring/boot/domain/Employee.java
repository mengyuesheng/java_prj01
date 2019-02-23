package com.prj.spring.boot.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
@Entity
@Table(name="tb_employee")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id // 主键
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 自增长策略
	 private Long employeeID;
	
	@NotEmpty(message = "姓名不能为空")
	@Column(nullable = false,length=20) // 映射为字段，值不能为空
	 private String employeeName;

	 private boolean employeeSex;
	 
	 private Timestamp employeeBirth;
	 
	 @Column(length=20)
	 private String employeePhone;
	 
	 @Column(length=50)
	 private String employeePlace;
	 
	 private Timestamp joinTime;
	 
	 @NotEmpty(message = "密码不能为空")
	 @Size(max=100)
	 @Column(length = 100)
	 private String password;
	 
	 private boolean isLead;
	 
	 protected Employee() {
		
	}

	public Employee(Long employeeID, String employeeName, boolean employeeSex, Timestamp employeeBirth,
			String employeePhone, String employeePlace, Timestamp joinTime, String password, boolean isLead) {
		this.employeeID = employeeID;
		this.employeeName = employeeName;
		this.employeeSex = employeeSex;
		this.employeeBirth = employeeBirth;
		this.employeePhone = employeePhone;
		this.employeePlace = employeePlace;
		this.joinTime = joinTime;
		this.password = password;
		this.isLead = isLead;
	}

	public Long getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(Long employeeID) {
		this.employeeID = employeeID;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public boolean isEmployeeSex() {
		return employeeSex;
	}

	public void setEmployeeSex(boolean employeeSex) {
		this.employeeSex = employeeSex;
	}

	public Timestamp getEmployeeBirth() {
		return employeeBirth;
	}

	public void setEmployeeBirth(Timestamp employeeBirth) {
		this.employeeBirth = employeeBirth;
	}

	public String getEmployeePhone() {
		return employeePhone;
	}

	public void setEmployeePhone(String employeePhone) {
		this.employeePhone = employeePhone;
	}

	public String getEmployeePlace() {
		return employeePlace;
	}

	public void setEmployeePlace(String employeePlace) {
		this.employeePlace = employeePlace;
	}

	public Timestamp getJoinTime() {
		return joinTime;
	}

	public void setJoinTime(Timestamp joinTime) {
		this.joinTime = joinTime;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isLead() {
		return isLead;
	}

	public void setLead(boolean isLead) {
		this.isLead = isLead;
	}

	@Override
	public String toString() {
		return "Employee [employeeID=" + employeeID + ", employeeName=" + employeeName + ", employeeSex=" + employeeSex
				+ ", employeeBirth=" + employeeBirth + ", employeePhone=" + employeePhone + ", employeePlace="
				+ employeePlace + ", joinTime=" + joinTime + ", password=" + password + ", isLead=" + isLead + "]";
	}
	 
}
