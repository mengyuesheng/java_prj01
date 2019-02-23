package com.prj.spring.boot.domain;

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
@Table(name="tb_message")
public class Message {
	private static final long serialVersionUID = 1L;
	
	@Id // 主键
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 自增长策略
	private Long messageID;
	
	@NotEmpty(message = "摘要不能为空")
	@Size(min=2, max=300)
	@Column(nullable = false) // 映射为字段，值不能为空
	private String messageTitle;
	
	@Lob  //对应数据库Long text
	@Basic(fetch=FetchType.LAZY)  //懒加载
	@NotEmpty(message="消息内容不能为空")
	@Size(min=2)
	@Column(nullable=false)
	private String messageContent;
	
	@OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	@JoinColumn(name="employeeID")
	private Employee employee;
	
	@Column(nullable = false) // 映射为字段，值不能为空
	@org.hibernate.annotations.CreationTimestamp  // 由数据库自动创建时间
	private Timestamp publishTime;
	
	protected Message() {
		
	}

	public Message(Long messageID, String messageTitle, String messageContent, Employee employee,
			Timestamp publishTime) {
		super();
		this.messageID = messageID;
		this.messageTitle = messageTitle;
		this.messageContent = messageContent;
		this.employee = employee;
		this.publishTime = publishTime;
	}

	public Long getMessageID() {
		return messageID;
	}

	public void setMessageID(Long messageID) {
		this.messageID = messageID;
	}

	public String getMessageTitle() {
		return messageTitle;
	}

	public void setMessageTitle(String messageTitle) {
		this.messageTitle = messageTitle;
	}

	public String getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Timestamp getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(Timestamp publishTime) {
		this.publishTime = publishTime;
	}

	@Override
	public String toString() {
		return "Message [messageID=" + messageID + ", messageTitle=" + messageTitle + ", messageContent="
				+ messageContent + ", employee=" + employee + ", publishTime=" + publishTime + "]";
	}
	
}
