package org.app.service.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.AUTO;
import javax.persistence.OneToMany;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.CascadeType.ALL;



@Entity
public class Team implements Serializable{

	@Id
	@GeneratedValue(strategy = AUTO)
	private Integer id_team;
	@ManyToOne
	private Project project;
	private String name;
	
	@OneToMany(fetch = EAGER, cascade = ALL)
	private List<Student> students = new ArrayList<>();
	
	public Integer getId_team() {
		return id_team;
	}
	public void setId_team(Integer id_team) {
		this.id_team = id_team;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public Team(Integer id_team, Project project, String name, List<Student> students) {
		super();
		this.id_team = id_team;
		this.project = project;
		this.name = name;
		this.students = students;
	}
	public Team() {
		super();
	}
	
}