package com.nik.ncompany.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nik.ncompany.domain.Employee;
import com.nik.ncompany.domain.EmployeeList;
import com.nik.ncompany.services.EmployeeDaoService;

@Controller
public class EmployeeController {
	
	@Autowired
	@Qualifier("employeeDaoServiceImpl")
	private EmployeeDaoService employeeDaoServiceImpl;
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	//http://localhost:8080/ncompany/addEmployee
	@RequestMapping(value = "/addEmployee", method = RequestMethod.GET)
	public String addEmployee(Locale locale, Model model) {
		logger.info("Wel {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate);
		return "addEmployee";
	}

	//http://localhost:8080/ncompany/employeeList
	@RequestMapping(value = "/employeeList", method = RequestMethod.GET)
	public ModelAndView employeeList(Locale locale, Model model) {
		//logger.info("Wel {}.", locale);
		ModelAndView modelView;
		List<Employee> empList;
		EmployeeList listOfEmployees = new EmployeeList();
		empList = employeeDaoServiceImpl.getEmployeeList();
		listOfEmployees.setEmployeeList(empList);
		modelView = new ModelAndView("/employeeList");
		modelView.addObject("employeeList", listOfEmployees.getSList());
		return modelView;
	}

}
