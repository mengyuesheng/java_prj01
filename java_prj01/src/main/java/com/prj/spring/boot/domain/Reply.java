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
@Table(name="tb_reply")
public class Reply implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id // 主键
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 自增长策略
	private Long replyID;
	
	@Lob
	@Basic(fetch=FetchType.LAZY) // 懒加载
	@NotEmpty(message = "消息回复内容不能为空")
	@Size(min=2)
	@Column(nullable = false) // 映射为字段，值不能为空
	private String replyContent;
	
	@Column(nullable = false) // 映射为字段，值不能为空
	@org.hibernate.annotations.CreationTimestamp  // 由数据库自动创建时间
	private Timestamp replyTime;
	
	@OneToOne(cascade=CascadeType.DETACH)
	@JoinColumn(name="employeeID")
	private Employee employee;
	
	@OneToOne(cascade = CascadeType.DETACH,fetch=FetchType.LAZY)
	@JoinColumn(name="messageID")
	private Message message; 
	
	protected Reply() {
		
	}

	public Reply(Long replyID, String replyContent, Timestamp replyTime, Message message) {
		super();
		this.replyID = replyID;
		this.replyContent = replyContent;
		this.replyTime = replyTime;
		this.message = message;
	}

	public Long getReplyID() {
		return replyID;
	}

	public void setReplyID(Long replyID) {
		this.replyID = replyID;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public Timestamp getReplyTime() {
		return replyTime;
	}

	public void setReplyTime(Timestamp replyTime) {
		this.replyTime = replyTime;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Reply [replyID=" + replyID + ", replyContent=" + replyContent + ", replyTime=" + replyTime
				+ ", message=" + message + ", employee=" + employee + "]";
	}
	
}
