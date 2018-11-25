package org.app.service.entities;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Enroll {

	@Id
	@GeneratedValue
	Integer id_enroll;
	@ManyToOne
	Student student;
	@ManyToOne
	Project project;
	@Temporal(TemporalType.DATE)
	Date endroll_date;
	
	public Integer getId_enroll() {
		return id_enroll;
	}
	public void setId_enroll(Integer id_enroll) {
		this.id_enroll = id_enroll;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public Date getEndroll_date() {
		return endroll_date;
	}
	public void setEndroll_date(Date endroll_date) {
		this.endroll_date = endroll_date;
	}
	public Enroll(Integer id_enroll, Student student, Project project, Date endroll_date) {
		super();
		this.id_enroll = id_enroll;
		this.student = student;
		this.project = project;
		this.endroll_date = endroll_date;
	}
	public Enroll() {
		super();
	}
}