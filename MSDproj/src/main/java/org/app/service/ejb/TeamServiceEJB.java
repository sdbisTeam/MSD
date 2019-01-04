package org.app.service.ejb;

import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.app.service.entities.Team;

@Path("team")
@Stateless @LocalBean
public class TeamServiceEJB implements TeamService{

	private static Logger logger = Logger.getLogger(TeamServiceEJB.class.getName());
	//private static Account Account = Account.getAccount())
	
	@PersistenceContext(unitName="MSD")
	private EntityManager em;
	//constructor
	public TeamServiceEJB() {
	}
	
	@PostConstruct
	public void init() {
		//Logger.info("POSTCONSTRUCT-INIT : " + this.em);
	}
	//create and update
	
	@Override
	@PUT @Path("/{teamToAdd}") 
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public Team addTeam(Team teamToAdd) {
		em.persist(teamToAdd);
		em.flush();
		em.refresh(teamToAdd);
		return teamToAdd;	
		
	}
	
	//read
	@Override 
	@GET @Path("/{id_team}") 
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Team getTeamByTeamID( @PathParam("id_team") Integer id_team) {
		
		return em.find(Team.class, id_team);
	}
	
	/*
	@Override
	@GET @Path("/{id_team}") 
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Team getId_team(@PathParam("id_team") Integer id_team) {
		Team team = super.getId_team(id_team);
		//Logger.info( " jshdij" + id_team + team);
		return team;
	}
	
	*/
	@Override
	@GET
	//@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Collection<Team> getTeam(){
		List<Team> teams = em.createQuery("SELECT p FROM Team p", Team.class).getResultList();
		return teams;
	}
	//remove
	@DELETE @Path("/{teamToDelete}")
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public String removeTeam(@PathParam("teamToDelete") Team teamToDelete) {
		teamToDelete = em.merge(teamToDelete);
		em.remove(teamToDelete);
		em.flush();
		return "True";
	}
	//custom read custom query
	@Override
	public Team getTeamByName(String title) {
		return em.createQuery("SELECT p FROM Team p Where p.title = :title ", Team.class).setParameter("title", title).getSingleResult();
	}
	//other 
	public String sayRest() {
		return "Team Service is on ....";
	}
	
	
}
