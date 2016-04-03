package com.nik.ncompany.resthandlers;


import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.nik.ncompany.domain.Employee;
import com.nik.ncompany.domain.EmployeeList;
import com.nik.ncompany.exception.UnknownResourceException;
import com.nik.ncompany.services.EmployeeDaoService;

@Path("/emprestapp")
public class EmployeeRestHandler {
	
	@Autowired
	private EmployeeDaoService employeeDaoServiceImpl;
	private Logger logger = Logger.getLogger(EmployeeRestHandler.class);
	
	@GET
	@Path("/employee")
	@Produces("application/xml")
	public EmployeeList getEmployeeList() {
		
		List<Employee> empList;
		EmployeeList listOfEmployees = new EmployeeList();
		empList = employeeDaoServiceImpl.getEmployeeList();
		listOfEmployees.setEmployeeList(empList);
		return listOfEmployees;
		
	}
}
