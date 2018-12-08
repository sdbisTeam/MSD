package org.app.service.entities;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue;
@Entity
public class Benefits implements Serializable{

	@Id
	@GeneratedValue
	private Integer id_benefits;
	private Double payment_amount;
	private String certification;
	private String extras;
	@OneToMany(fetch = EAGER, cascade = ALL)
	private List<Team> teams = new ArrayList<>();
	
	public Integer getId_benefits() {
		return id_benefits;
	}
	public void setId_benefits(Integer id_benefits) {
		this.id_benefits = id_benefits;
	}
	public Double getPayment_amount() {
		return payment_amount;
	}
	public void setPayment_amount(Double payment_amount) {
		this.payment_amount = payment_amount;
	}
	public String getCertification() {
		return certification;
	}
	public void setCertification(String certification) {
		this.certification = certification;
	}
	public String getExtras() {
		return extras;
	}
	public void setExtras(String extras) {
		this.extras = extras;
	}
	public List<Team> getTeams() {
		return teams;
	}
	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}
	public Benefits(Integer id_benefits, Double payment_amount, String certification, String extras, List<Team> teams) {
		super();
		this.id_benefits = id_benefits;
		this.payment_amount = payment_amount;
		this.certification = certification;
		this.extras = extras;
		this.teams = teams;
	}
	public Benefits() {
		super();
	}
}