package com.nik.ncompany.resthandlers;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.nik.ncompany.domain.Employee;
import com.nik.ncompany.domain.EmployeeList;
import com.nik.ncompany.services.EmployeeDaoService;
import com.nik.ncompany.services.EmployeeDaoServiceImpl;

@Path("/emprestapp")
public class EmployeeRestHandler {

	@Autowired
	@Qualifier("employeeDaoServiceImpl")
	private EmployeeDaoService employeeDaoServiceImpl;
	private Logger logger = Logger.getLogger(EmployeeRestHandler.class);

	@GET
	@Path("/employee")
	@Produces("application/xml")
	public EmployeeList getEmployeeList() {
		logger.info("I am inside the EmployeeRestfull1---");
		List<Employee> empList;
		EmployeeList listOfEmployees = new EmployeeList();
		logger.info("I am inside the EmployeeRestfull1");
		empList = employeeDaoServiceImpl.getEmployeeList();
		logger.info("I am inside the EmployeeRestfull2"+empList);
		listOfEmployees.setEmployeeList(empList);
		logger.info("I am inside the EmployeeRestfull3");
		return listOfEmployees;

	}
}
