package com.nik.ncompany.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nik.ncompany.domain.Project;
import com.nik.ncompany.domain.ProjectList;

import com.nik.ncompany.services.ProjectDaoServices;
@Controller
public class ProjectController {
	@Autowired
	@Qualifier("projectDaoServiceImpl")
	ProjectDaoServices projectDaoServiceImpl;
	
	//http://localhost:8080/ncompany/addProject
	@RequestMapping(value = "/addProject", method = RequestMethod.GET)
	public String addProject(Locale locale, Model model) {
		return "addProject";
	}
	
	
	//http://localhost:8080/ncompany/projectList
	@RequestMapping(value = "/projectList", method = RequestMethod.GET)
	public ModelAndView employeeList(Locale locale, Model model) {
		ModelAndView modelView;
		List<Project> projList;
		ProjectList listOfProjects = new ProjectList();
		projList = projectDaoServiceImpl.getProjectList();
		listOfProjects.setProjectList(projList);
		modelView = new ModelAndView("/projectList");
		modelView.addObject("projectList", listOfProjects.getSList());
		System.out.println("the list of dept is "+listOfProjects.getSList().toString());
		return modelView;
	}
}
