package org.app.service.ejb;

import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.app.service.entities.Project;


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
	public Project addProject(Project projectToAdd) {
		em.persist(projectToAdd);
		em.flush();
		em.refresh(projectToAdd);
		return projectToAdd;	
		
	}
	
	//read
	@Override
	public Project getProjectByProjectID(Integer id_project) {
		return em.find(Project.class, id_project);
	}
	public Collection<Project> getProject(){
		List<Project> projects = em.createQuery("SELECT p FROM Project p", Project.class).getResultList();
		return projects;
	}
	//remove
	public String removeProject(Project projectToDelete) {
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