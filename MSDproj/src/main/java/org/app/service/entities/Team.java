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
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.CascadeType.ALL;


@XmlRootElement(name="team")
@XmlAccessorType(XmlAccessType.NONE)
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
	@XmlElement
	public Integer getId_team() {
		return id_team;
	}
	public void setId_team(Integer id_team) {
		this.id_team = id_team;
	}
	@XmlElement
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	@XmlElement
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@XmlElementWrapper(name= "students") @XmlElement(name="student")
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
	
	
	
	
	public Team(Integer id_team, String name) {
		super();
		this.id_team = id_team;
		this.name = name;
	}
	public Team(String name) {
		super();
		this.name = name;
	}




	public static String BASE_URL = Project.BASE_URL;
	@XmlElement(name = "link")
	public AtomLink getLink() throws Exception{
		String restUrl = BASE_URL + this.getProject().getId_project() + "/teams/" + this.getId_team();
		return new AtomLink(restUrl, "get-team");
	}
}