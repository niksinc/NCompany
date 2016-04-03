package com.nik.ncompany.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.nik.ncompany.dao.ProjectDao;
import com.nik.ncompany.dao.jdbc.ProjectDaojdbc;
import com.nik.ncompany.domain.Project;

@Service("projectDaoServiceImpl")
public class ProjectDaoServiceImpl implements ProjectDaoServices {

	@Autowired
	@Qualifier("projectDaojdbc")
	private ProjectDao projectDaojdbc;
	
	@Override
	public Project findProjectById(int projId) {
	
		return projectDaojdbc.findProjectById(projId);
	}

	@Override
	public Project findProjectByName(String projName) {
		
		return projectDaojdbc.findProjectByName(projName);
	}

	@Override
	public void insertProject(Project project) {
		projectDaojdbc.insertProject(project);
		
	}

	@Override
	public void deleteProject(Project project) {
		projectDaojdbc.deleteProject(project);
		
	}

	@Override
	public int updateProject(int projId, Project project) {
		
		return projectDaojdbc.updateProject(projId, project);
	}

	@Override
	public int getProjectCount() {
		// TODO Auto-generated method stub
		return projectDaojdbc.getProjectCount();
	}

	@Override
	public List<Project> getProjectList() {
		// TODO Auto-generated method stub
		return projectDaojdbc.getProjectList();
	}

}
