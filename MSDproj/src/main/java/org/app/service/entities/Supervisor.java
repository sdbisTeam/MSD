package org.app.service.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.CascadeType.ALL;

@Entity
public class Supervisor {

	@Id
	@GeneratedValue
	private Integer id_supervisor;
	private String firstname;
	private String lastname;
	private String specialisation;
	
	@OneToMany(fetch = EAGER, cascade = ALL)
	private List<Team> teams = new ArrayList<>();
	
	public Integer getId_supervisor() {
		return id_supervisor;
	}
	public void setId_supervisor(Integer id_supervisor) {
		this.id_supervisor = id_supervisor;
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
	public String getSpecialisation() {
		return specialisation;
	}
	public void setSpecialisation(String specialisation) {
		this.specialisation = specialisation;
	}
	public List<Team> getTeams() {
		return teams;
	}
	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}
	public Supervisor(Integer id_supervisor, String firstname, String lastname, String specialisation,
			List<Team> teams) {
		super();
		this.id_supervisor = id_supervisor;
		this.firstname = firstname;
		this.lastname = lastname;
		this.specialisation = specialisation;
		this.teams = teams;
	}
	public Supervisor() {
		super();
	}
}