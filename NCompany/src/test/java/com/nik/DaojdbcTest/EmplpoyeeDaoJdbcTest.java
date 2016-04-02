package com.nik.DaojdbcTest;

import static org.junit.Assert.*;

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
import com.nik.ncompany.domain.Employee;


@ContextConfiguration("classpath:ncompany-test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class EmplpoyeeDaoJdbcTest {

	@Autowired
	@Qualifier("employeeDaojdbc")
	private EmployeeDao employeeDaojdbc;
	private Employee setupEmployee;   /*  Initialized in the setup() method  */
	private int setupEmployeemplId;    /*  Initialized in the setup() method  */
	private Logger logger =  Logger.getLogger(EmplpoyeeDaoJdbcTest.class);
	
	@Before
	public void setup() {
		/* We will use this Employee in various tests. The student already be
		 * in the database
		 */
		setupEmployee = new Employee("nikhil", "surti","n@n.com","9558885756");
		setupEmployeemplId = 1;   /* In the DB, the student should have this id */
		setupEmployee.setEmpId(setupEmployeemplId);
	}
	
	
	/* The following test demonstrate the expected employee is kin the database or 
	 * not if the given employee is not in the database then the test will failed
	 */ 
		@Test
		public void testFindEmployeeByName() throws Exception {
			String fName = setupEmployee.getfName();
			Employee empFromDb;
			empFromDb = employeeDaojdbc.findEmployeeByName(fName);
			assertNotNull(empFromDb);
			assertEquals(setupEmployee.getEmpId(),empFromDb.getEmpId());
		}
		
		
		/* The Following] test is expect the illegal argument id the employee
		 * object will inserted in the database then our test will failed
		 * if it will not inserted then our test will pass
		 */
		@Test (expected=IllegalArgumentException.class)
		public void testNullStudentInsert(){
			employeeDaojdbc.insertEmployee(null);
		}
		
		/* This test will demonstrate the handling of unchecked exception */
		@Test 
		public void testBadEmailInsert(){
			int empCount = employeeDaojdbc.getEmployeeCount();
					
			Employee emp = new Employee ("Ram","surti",null,"741852963");
			try{
				employeeDaojdbc.insertEmployee(emp );
				fail();
			}
			catch(DataIntegrityViolationException ex){
				/* The Employee insert will not have rollback 
				 * because we have a checked exception */
				
				logger.info("Employee isert failed becouse exception"+ex);
			}
			assertTrue(empCount == employeeDaojdbc.getEmployeeCount());
		}


}
