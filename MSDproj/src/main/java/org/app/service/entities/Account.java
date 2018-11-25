package org.app.service.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToOne;


@Entity
public class Account {

	@Id
	@GeneratedValue
	private Integer id_acc;
	private String username;
	private String password;
	private String email;
	private Boolean active;
	@OneToOne
	private Student student;
	
	public Integer getId_acc() {
		return id_acc;
	}
	public void setId_acc(Integer id_acc) {
		this.id_acc = id_acc;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Account(Integer id_acc, String username, String password, String email, Boolean active, Student student) {
		super();
		this.id_acc = id_acc;
		this.username = username;
		this.password = password;
		this.email = email;
		this.active = active;
		this.student = student;
	}
	public Account() {
		super();
	}
}