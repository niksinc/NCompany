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

import com.nik.ncompany.domain.Department;
import com.nik.ncompany.domain.DepartmentList;
import com.nik.ncompany.domain.Employee;
import com.nik.ncompany.domain.EmployeeList;
import com.nik.ncompany.services.DepartmentDaoService;

	@Controller
public class DepartmentController {
	
	@Autowired
	@Qualifier("departmentDaoServiceImpl")
	DepartmentDaoService departmentDaoServiceImpl;
	private static final Logger logger = LoggerFactory.getLogger(DepartmentController.class);
	
	//http://localhost:8080/ncompany/addDepartment
	@RequestMapping(value = "/addDepartment", method = RequestMethod.GET)
	public ModelAndView addDepartment(Locale locale, Model model) {
		ModelAndView modelView;
		modelView = new ModelAndView("/addDepartment");
		modelView.addObject("servertime","1111");
		return modelView;
	}	
	
	
	//http://localhost:8080/ncompany/departmentList
	@RequestMapping(value = "/departmentList", method = RequestMethod.GET)
	public ModelAndView employeeList(Locale locale, Model model) {
		//logger.info("Wel {}.", locale);
		ModelAndView modelView;
		List<Department> deptList;
		DepartmentList listOfDepartments = new DepartmentList();
		deptList = departmentDaoServiceImpl.getDepartmentList();
		listOfDepartments.setDepartmentList(deptList);
		modelView = new ModelAndView("/departmentList");
		modelView.addObject("departmentList", listOfDepartments.getSList());
		System.out.println("the list of dept is "+listOfDepartments.getSList().toString());
		
		return modelView;
	}
	

}
