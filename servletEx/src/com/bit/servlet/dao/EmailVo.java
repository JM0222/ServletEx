package com.bit.servlet.dao;

import java.util.Date;

public class EmailVo {
	// field
	private Long no; // PK
	private String lastName;
	private String firstName;
	private String email;
	private Date createAt;
	
	// constructor
	// VO 객체에는 반드시 기본생성자 있어야한다
	public EmailVo() {
	
	}
	public EmailVo(String lastName, String firstName, String email) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;		
	}
	public EmailVo(String lastName, String firstName, String email, Date createAt) {
		this(lastName, firstName, email); 
		this.createAt = createAt;
	}
	public EmailVo(Long no, String lastName, String firstName, String email, Date createAt) {
		this(lastName, firstName, email, createAt);
		this.no = no;
	}
	// Getter / Setter
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	// to String
	@Override
	public String toString() {
		return "EmailVo [no=" + no + ", lastName=" + lastName + ", firstName=" + 
	firstName + ", email=" + email
				+ ", createAt=" + createAt + "]";
	}
	
	
}
