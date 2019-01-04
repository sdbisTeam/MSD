package org.app.service.ejb;

import java.util.Collection;

import javax.ejb.Remote;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;

import org.app.service.entities.Team;
@Remote
public interface TeamService {

	//create or update
	@PUT
	Team addTeam(Team teamToAdd);
	
	//delete
	@DELETE
	String removeTeam(Team teamToDelete);
	
	//read
	@GET
	Team getTeamByTeamID(Integer id_team);
	Collection<Team> getTeam();
	/*
	@GET
	Team getById(Integer id_team);
	
	*/
	//custom read custom query
	Team getTeamByName(String teamTitle);
	
	//others
	String sayRest();
	
}
