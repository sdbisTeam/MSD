package org.app.service.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
//import javax.persistence.Inheritance;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.AUTO;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
//import org.app.service.entities.People;

@Entity

public class Student {

	@Id
	@GeneratedValue(strategy = AUTO)
	private Integer id_stud;
	private String firstname;
	private String lastname;
	@Temporal(TemporalType.DATE)
	private Date birthdate;
	private String gender;
	private String adress;
	private String university;
	public Integer getId_stud() {
		return id_stud;
	}
	public void setId_stud(Integer id_stud) {
		this.id_stud = id_stud;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getUniversity() {
		return university;
	}
	public void setUniversity(String university) {
		this.university = university;
	}
	public Student(Integer id_stud, String firstname, String lastname, Date birthdate, String gender, String adress,
			String university) {
		super();
		this.id_stud = id_stud;
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthdate = birthdate;
		this.gender = gender;
		this.adress = adress;
		this.university = university;
	}
	public Student() {
		super();
	}
}