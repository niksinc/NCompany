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

import com.nik.ncompany.dao.DepartmentDao;
import com.nik.ncompany.domain.Department;


@ContextConfiguration("classpath:ncompany-test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class DepartmentdaojdbcTest {
	
	@Autowired
	@Qualifier("departmentDaojdbc")
	private DepartmentDao departmentDaojdbc;
	private Department setupDepartment;   /*  Initialized in the setup() method  */
	private int setupDepartmentId;    /*  Initialized in the setup() method  */
	private Logger logger =  Logger.getLogger(DepartmentdaojdbcTest.class);
	
	@Before
	public void setup() {
		/* We will use this Department in various tests. The department already be
		 * in the database
		 */
		setupDepartment = new Department("account", "California");
		setupDepartmentId = 1;   /* In the DB, the department should have this id */
		setupDepartment.setDeptId(setupDepartmentId);
	}
	
	
	/* The following test demonstrate the expected department is kin the database or 
	 * not if the given department is not in the database then the test will failed
	 */ 
		@Test
		public void testFindDepartmentByName() throws Exception {
			String deptName = setupDepartment.getDeptName();
			Department deptFromDb;
			deptFromDb = departmentDaojdbc.findDepartmentByName(deptName);
			assertNotNull(deptFromDb);
			assertEquals(setupDepartment.getDeptId(),deptFromDb.getDeptId());
		}
		
		/* The Following] test is expect the illegal argument id the department
		 * object will inserted in the database then our test will failed
		 * if it will not inserted then our test will pass
		 */
		@Test (expected=IllegalArgumentException.class)
		public void testNullDepartmentInsert(){
			departmentDaojdbc.insertDepartment(null);
		}
		
		/* This test will demonstrate the handling of unchecked exception */
		@Test 
		public void testBadDEpartmentInsert(){
			int empCount = departmentDaojdbc.getDepartmentCount();
					
			Department department = new Department(null,"cali");
			try{
				departmentDaojdbc.insertDepartment(department);
				fail();
			}
			catch(DataIntegrityViolationException ex){
				/* The Department insert will not have rollback 
				 * because we have a checked exception */
				logger.info("Employee isert failed becouse exception"+ex);
			}
			assertTrue(empCount == departmentDaojdbc.getDepartmentCount());
		}
}
