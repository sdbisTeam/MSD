package org.app.service.entities;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
//import static javax.persistence.TemporalType.DATE;
import javax.persistence.OneToMany;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.CascadeType.ALL;


@XmlRootElement(name="project")
@XmlAccessorType(XmlAccessType.NONE)
@Entity
public class Project implements Serializable{
	
	@Id
	@GeneratedValue
	private Integer id_project;
	private String title;
	private String description;
	private Integer projectlevel;
	
	@Temporal(TemporalType.DATE)
	private Date start_project;
	@Temporal(TemporalType.DATE)
	private Date end_project;
	
	
	@OneToMany(fetch = EAGER, cascade = ALL)
	private List<Team> teams = new ArrayList<>();
	
	@XmlElement
	public Integer getId_project() {
		return id_project;
	}
	public void setId_project(Integer id_project) {
		this.id_project = id_project;
	}
	@XmlElement
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@XmlElement
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@XmlElement
	public Integer getProjectlevel() {
		return projectlevel;
	}
	public void setProjectlevel(Integer projectlevel) {
		this.projectlevel = projectlevel;
	}
	@XmlElement
	public Date getStart_project() {
		return start_project;
	}
	public void setStart_project(Date start_project) {
		this.start_project = start_project;
	}
	@XmlElement
	public Date getEnd_project() {
		return end_project;
	}
	public void setEnd_project(Date end_project) {
		this.end_project = end_project;
	}
	@XmlElementWrapper(name= "teams") @XmlElement(name="team")
	public List<Team> getTeams() {
		return teams;
	}
	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}
	public Project(Integer id_project, String title, String description, Integer projectlevel, Date start_project,
			Date end_project, List<Team> teams) {
		super();
		this.id_project = id_project;
		this.title = title;
		this.description = description;
		this.projectlevel = projectlevel;
		this.start_project = start_project;
		this.end_project = end_project;
		this.teams = teams;
	}
	public Project(Integer id_project, String title) {
		super();
		this.id_project = id_project;
		this.title = title;
		
	}
	
	
	public Project(String title) {
		super();
		this.title = title;
	}
	public Project() {
		super();
	}
	
	
	
	

	
	public static String BASE_URL = "http://localhost:8080/MSDproj/rest/project/";
	@XmlElement(name = "link")
	public AtomLink getLink() throws Exception{
		String restUrl = BASE_URL + this.getId_project() ;
		return new AtomLink(restUrl, "get-project");
	}
	
}