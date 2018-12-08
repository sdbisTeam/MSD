package org.app.service.ejb.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import javax.ejb.EJB;

import org.app.service.ejb.ProjectService;
import org.app.service.ejb.ProjectServiceEJB;
import org.app.service.entities.Project;
import org.app.service.rest.test.TestDataServiceRest;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
//import org.jboss.logging.Logger;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import java.util.logging.Logger;

@RunWith(Arquillian.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestProjectServiceEJBArq {

	//private static Logger Logger = Logger.getLogger(TestProjectServiceEJBArq.class.getName());
	private static Logger logger = Logger.getLogger(TestProjectServiceEJBArq.class.getName());
	
	@EJB
	private static ProjectService service;
	
	@Deployment
	public static Archive<?> createDeployment(){
		return ShrinkWrap
				.create( WebArchive.class,"SCRUM-S3-test.war")
				.addPackage(Project.class.getPackage())
				.addClass(ProjectService.class).addClass(ProjectServiceEJB.class)
				.addAsResource("META-INF/persistence.xml")
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
	}
	
/*
	@Test
	public void test1_GetMessage() {
		Logger.info("DEBUG: Junit TESTING: getMessage ...");
		String response = service.getMessage();
		assertNotNull("Data Service failed!", response);
		Logger.info("DEBUG: EJB Response ..." + response);
	}
	*/
	
	@Test
	public void test4_GetProjects() {
		//Logger.info("DEBUG: Junit TESTING: testGetProjects ...");
		
		Collection<Project> projects = service.getProject();
		assertTrue("Fail to read projects!", projects.size() > 0);
	}
	
	@Test
	public void test3_AddProject() {
		//Logger.info("DEBUG: Junit TESTING: testAddProjects ...");
		
		Integer projectsToAdd = 3;
		for (int i=1; i <= projectsToAdd; i++) {
			service.addProject(new Project(null, "Project_" + (100+i)));
		}
		
		Collection<Project> projects = service.getProject();
		assertTrue("Fail to add projects!", projects.size() == projectsToAdd);
	}
	
	@Test
	public void test2_DeleteProject() {
		//Logger.info("DEBUG: Junit TESTING: testDeleteProject ...");
		
		Collection<Project> projects = service.getProject();
		
		for (Project p:projects) 
			service.removeProject(p);
		
		Collection<Project> projectsAfterDelete = service.getProject();
		assertTrue("Fail to read projects!", projectsAfterDelete.size() == 0);
	}

}
