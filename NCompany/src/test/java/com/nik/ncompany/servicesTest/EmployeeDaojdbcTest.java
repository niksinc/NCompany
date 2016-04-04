package com.nik.ncompany.servicesTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.nik.ncompany.domain.Employee;
import com.nik.ncompany.services.EmployeeDaoService;

@ContextConfiguration("classpath:ncompany-test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@TransactionConfiguration
public class EmployeeDaojdbcTest {
	
	//@Autowired
	//@Qualifier("employeeDaoServiceImpl")
	//private EmployeeDaoService employeeDaoServiceImpl;
	
	@Test //(expected=ProductNotFoundException.class)
	public void plL() {
		//Project project=new Project("asadas",1, "2016-11-11");
		//Employee employee = employeeDaoServiceImpl.findEmployeeByName("nikhil");
		
		//projectDaoServiceImpl.updateProject(33, project);
	}
}
