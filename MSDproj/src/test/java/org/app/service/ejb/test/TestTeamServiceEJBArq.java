package org.app.service.ejb.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import javax.ejb.EJB;

import org.app.service.ejb.TeamService;
import org.app.service.ejb.TeamServiceEJB;
import org.app.service.entities.Team;
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
public class TestTeamServiceEJBArq {

	//private static Logger Logger = Logger.getLogger(TestTeamServiceEJBArq.class.getName());
	private static Logger logger = Logger.getLogger(TestTeamServiceEJBArq.class.getName());
	
	@EJB
	private static TeamService service;
	
	@Deployment
	public static Archive<?> createDeployment(){
		return ShrinkWrap
				.create( WebArchive.class,"SCRUM-S3-test.war")
				.addPackage(Team.class.getPackage())
				.addClass(TeamService.class).addClass(TeamServiceEJB.class)
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
	public void test4_GetTeams() {
		//Logger.info("DEBUG: Junit TESTING: testGetTeams ...");
		
		Collection<Team> teams = service.getTeam();
		assertTrue("Fail to read teams!", teams.size() > 0);
	}
	
	@Test
	public void test3_AddTeam() {
		//Logger.info("DEBUG: Junit TESTING: testAddTeams ...");
		
		Integer teamsToAdd = 3;
		for (int i=1; i <= teamsToAdd; i++) {
			service.addTeam(new Team(null, "Team_" + (100+i)));
		}
		
		Collection<Team> teams = service.getTeam();
		assertTrue("Fail to add teams!", teams.size() == teamsToAdd);
	}
	
	@Test
	public void test2_DeleteTeam() {
		//Logger.info("DEBUG: Junit TESTING: testDeleteTeam ...");
		
		Collection<Team> teams = service.getTeam();
		
		for (Team p:teams) 
			service.removeTeam(p);
		
		Collection<Team> teamsAfterDelete = service.getTeam();
		assertTrue("Fail to read teams!", teamsAfterDelete.size() == 0);
	}

}
