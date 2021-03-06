package org.app.service.ejb;

import java.util.Collection;

import javax.ejb.Remote;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;

import org.app.service.entities.Project;
@Remote
public interface ProjectService {

	//create or update
	@PUT
	Project addProject(Project projectToAdd);
	
	//delete
	@DELETE
	String removeProject(Project projectToDelete);
	
	//read
	@GET
	Project getProjectByProjectID(Integer id_project);
	Collection<Project> getProject();
	/*
	@GET
	Project getById(Integer id_project);
	
	*/
	//custom read custom query
	Project getProjectByName(String projectTitle);
	
	//others
	String sayRest();
	
}