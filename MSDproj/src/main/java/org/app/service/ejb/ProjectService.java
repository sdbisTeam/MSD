package org.app.service.ejb;

import java.util.Collection;

import javax.ejb.Remote;

import org.app.service.entities.Project;
@Remote
public interface ProjectService {

	//create or update
	Project addProject(Project projectToAdd);
	
	//delete
	String removeProject(Project projectToDelete);
	
	//read
	Project getProjectByProjectID(Integer id_project);
	Collection<Project> getProject();
	
	//custom read custom query
	Project getProjectByName(String projectTitle);
	
	//others
	String sayRest();
}