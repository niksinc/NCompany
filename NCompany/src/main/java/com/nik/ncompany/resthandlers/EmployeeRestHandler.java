package com.nik.ncompany.resthandlers;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.nik.ncompany.domain.Employee;
import com.nik.ncompany.domain.EmployeeList;
import com.nik.ncompany.exception.UnknownResourceException;
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
	@Produces("application/json")
	public EmployeeList getEmployeeList() {
		List<Employee> empList;
		EmployeeList listOfEmployees = new EmployeeList();
		empList = employeeDaoServiceImpl.getEmployeeList();
		listOfEmployees.setEmployeeList(empList);
		return listOfEmployees;
	}
	
	/* Test Url:
	 * http://localhost:8080/zuniversity/webservices/studrestapp/student/100
	 * See web.xml file for Jersey configuration
	 */
	@GET
	@Path("/employee/{id}")
	@Produces("application/xml, application/json")
	public Employee getEmployee(@PathParam("id") int id) {
		Employee employee = null;
		
		//stud = lookupStudent(id);
		employee = employeeDaoServiceImpl.findEmployeeById(id);
		if (employee == null) {
			throw new UnknownResourceException("Employee id: " + id + " is invalid");
		}
		
		return employee;
	}
	
	/* Test Url -- Post the data from file student.xml to:
	 * http://localhost:8080/zuniversity/webservices/studrestapp/student
	 * After doing the post, use a get command to retrieve the student (and verify that the post was successful).
	 */
	@POST
	@Path("/employee")
	@Produces("application/json, application/xml")
	@Consumes("application/json, application/xml")
	public Response addStudent(Employee newEmployee) {
		ResponseBuilder respBuilder;
		employeeDaoServiceImpl.addEmployee(newEmployee);
		respBuilder = Response.status(Status.CREATED);
		respBuilder.entity(newEmployee);
		return respBuilder.build();
	}
	
	/* Test Url:  Use HTTP Delete command
	 * http://localhost:8080/zuniversity/webservices/studrestapp/student/100
	 */
	@DELETE
	@Path("/employee/{id}")
	public Response deleteEmployee(@PathParam("id") int id) {
		Employee removedEmployee;
		ResponseBuilder respBuilder;
		
		removedEmployee = employeeDaoServiceImpl.deleteEmployeeById(id);
		if (removedEmployee == null) {
			respBuilder = Response.status(Status.NOT_FOUND);
		} else {
			respBuilder = Response.ok();
		}
		return respBuilder.build();
	}
	
}
