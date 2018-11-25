package org.app.service.entities;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.GeneratedValue;
@Entity
public class Schedule {

	@Id
	@GeneratedValue
	private Integer id_schedule;
	@Temporal(TemporalType.DATE)
	private Date start_date;
	@Temporal(TemporalType.DATE)
	private Date end_date;
	private String start_hour;
	private String end_hour;
	@OneToMany(fetch = EAGER, cascade = ALL)
	private List<Team> teams = new ArrayList<>();
	
	public Integer getId_schedule() {
		return id_schedule;
	}
	public void setId_schedule(Integer id_schedule) {
		this.id_schedule = id_schedule;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	public String getStart_hour() {
		return start_hour;
	}
	public void setStart_hour(String start_hour) {
		this.start_hour = start_hour;
	}
	public String getEnd_hour() {
		return end_hour;
	}
	public void setEnd_hour(String end_hour) {
		this.end_hour = end_hour;
	}
	public List<Team> getTeams() {
		return teams;
	}
	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}
	public Schedule(Integer id_schedule, Date start_date, Date end_date, String start_hour, String end_hour,
			List<Team> teams) {
		super();
		this.id_schedule = id_schedule;
		this.start_date = start_date;
		this.end_date = end_date;
		this.start_hour = start_hour;
		this.end_hour = end_hour;
		this.teams = teams;
	}
	public Schedule() {
		super();
	}
}
