package com.nik.ncompany.DaojdbcTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nik.ncompany.dao.EmployeeDao;
import com.nik.ncompany.dao.ProjectDao;
import com.nik.ncompany.domain.Employee;
import com.nik.ncompany.domain.Project;

@ContextConfiguration("classpath:ncompany-test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ProjectDaojdbcTest {
	
	@Autowired
	@Qualifier("projectDaojdbc")
	private ProjectDao projectDaojdbc;
	private Project setupProject;   /*  Initialized in the setup() method  */
	private int setupProjectId;    /*  Initialized in the setup() method  */
	private Logger logger =  Logger.getLogger(EmplpoyeeDaoJdbcTest.class);
	
	@Before
	public void setup() {
		/* We will use this Employee in various tests. The student already be
		 * in the database
		 */
		setupProject = new Project("phpproj", 1,"2016-2-2");
		setupProjectId = 1;   /* In the DB, the student should have this id */
		setupProject.setProjId(setupProjectId);
	}
	
	/* The following test demonstrate the expected employee is kin the database or 
	 * not if the given employee is not in the database then the test will failed
	 */ 
		@Test
		public void testFindEmployeeByName() throws Exception {
			String projName = setupProject.getProjName();
			Project projFromDb;
			projFromDb = projectDaojdbc.findProjectByName(projName);
			assertNotNull(projFromDb);
			assertEquals(setupProject.getProjId(),projFromDb.getProjId());
		}
		
		
		/* The Following] test is expect the illegal argument id the employee
		 * object will inserted in the database then our test will failed
		 * if it will not inserted then our test will pass
		 */
		@Test (expected=IllegalArgumentException.class)
		public void testNullStudentInsert(){
			projectDaojdbc.insertProject(null);
		}
		
		/* This test will demonstrate the handling of unchecked exception */
		@Test 
		public void testBadEmailInsert(){
			int projCount = projectDaojdbc.getProjectCount();
					
			Project project = new Project (null,2,"2015-11-11");
			try{
				projectDaojdbc.insertProject(project);
				fail();
			}
			catch(DataIntegrityViolationException ex){
				/* The Employee insert will not have rollback 
				 * because we have a checked exception */
				logger.info("Project isert failed becouse exception"+ex);
			}
			assertTrue(projCount == projectDaojdbc.getProjectCount());
		}
		
		
	

}
