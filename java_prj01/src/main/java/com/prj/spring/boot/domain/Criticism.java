package com.prj.spring.boot.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="tb_criticism")
public class Criticism implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id // 主键
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 自增长策略
	private Long id;
	
	@Lob  //对应数据库Long text
	@Basic(fetch=FetchType.LAZY)  //懒加载
	@NotEmpty(message="消息批复内容不能为空")
	@Size(min=2)
	@Column(nullable=false)
	private String criticismContent;
	
	@OneToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name="employeeID")
	private Employee employee;
	
	@Column(nullable = false) // 映射为字段，值不能为空
	@org.hibernate.annotations.CreationTimestamp  // 由数据库自动创建时间
	private Timestamp criticismTime;
	
	@OneToOne(cascade = CascadeType.DETACH)
	private Message message;
	
	public Criticism(Long id, String criticismContent, Employee employee, Timestamp criticismTime, Message message) {
		this.id = id;
		this.criticismContent = criticismContent;
		this.employee = employee;
		this.criticismTime = criticismTime;
		this.message = message;
	}


	protected Criticism() {	
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCriticismContent() {
		return criticismContent;
	}

	public void setCriticismContent(String criticismContent) {
		this.criticismContent = criticismContent;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Timestamp getCriticismTime() {
		return criticismTime;
	}

	public void setCriticismTime(Timestamp criticismTime) {
		this.criticismTime = criticismTime;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}


	@Override
	public String toString() {
		return "Criticism [id=" + id + ", criticismContent=" + criticismContent + ", employee=" + employee
				+ ", criticismTime=" + criticismTime + ", message=" + message + "]";
	} 
	
	
	
}
