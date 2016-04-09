package com.nik.ncompany.servicesTest;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.nik.ncompany.DaojdbcTest.EmplpoyeeDaoJdbcTest;
import com.nik.ncompany.domain.Employee;
import com.nik.ncompany.services.EmployeeDaoService;
import com.nik.ncompany.services.EmployeeDaoServiceImpl;

@ContextConfiguration("classpath:ncompany-test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)

@Transactional
@TransactionConfiguration
public class EmployeeDaoServiceTest {
	@Autowired
	@Qualifier("employeeDaoServiceImpl")
	private EmployeeDaoService employeeDaoServiceImpl;
	private Logger logger = Logger.getLogger(EmplpoyeeDaoJdbcTest.class);

	/* This test will demonstrate the handling of unchecked exception */
	@Test
	public void testBadEmailInsert() {
		int empCount = employeeDaoServiceImpl.getEmployeeCount();

		Employee emp = new Employee("Ram", "surti", null, "741852963");
		try {
			employeeDaoServiceImpl.addEmployee(emp);
			fail();
		} catch (DataIntegrityViolationException ex) {

			/*
			 * The Employee insert will not have rollback because we have a
			 * checked exception
			 */
			logger.info("Employee isert failed becouse exception" + ex);
		}
		assertTrue(empCount == employeeDaoServiceImpl.getEmployeeCount());
	}

}
