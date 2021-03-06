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

import org.app.service.entities.Project;

@Path("project")
@Stateless @LocalBean
public class ProjectServiceEJB implements ProjectService{

	private static Logger logger = Logger.getLogger(ProjectServiceEJB.class.getName());
	//private static Account Account = Account.getAccount())
	
	@PersistenceContext(unitName="MSD")
	private EntityManager em;
	//constructor
	public ProjectServiceEJB() {
	}
	
	@PostConstruct
	public void init() {
		//Logger.info("POSTCONSTRUCT-INIT : " + this.em);
	}
	//create and update
	
	@Override
	@PUT @Path("/{projectToAdd}") 
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public Project addProject(Project projectToAdd) {
		em.persist(projectToAdd);
		em.flush();
		em.refresh(projectToAdd);
		return projectToAdd;	
		
	}
	
	//read
	@Override 
	@GET @Path("/{id_project}") 
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Project getProjectByProjectID( @PathParam("id_project") Integer id_project) {
		
		return em.find(Project.class, id_project);
	}
	
	/*
	@Override
	@GET @Path("/{id_project}") 
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Project getId_project(@PathParam("id_project") Integer id_project) {
		Project project = super.getId_project(id_project);
		//Logger.info( " jshdij" + id_project + project);
		return project;
	}
	
	*/
	@Override
	@GET
	//@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Collection<Project> getProject(){
		List<Project> projects = em.createQuery("SELECT p FROM Project p", Project.class).getResultList();
		return projects;
	}
	//remove
	@DELETE @Path("/{projectToDelete}")
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public String removeProject(@PathParam("projectToDelete") Project projectToDelete) {
		projectToDelete = em.merge(projectToDelete);
		em.remove(projectToDelete);
		em.flush();
		return "True";
	}
	//custom read custom query
	@Override
	public Project getProjectByName(String title) {
		return em.createQuery("SELECT p FROM Project p Where p.title = :title ", Project.class).setParameter("title", title).getSingleResult();
	}
	//other 
	public String sayRest() {
		return "Project Service is on ....";
	}
	
	
}