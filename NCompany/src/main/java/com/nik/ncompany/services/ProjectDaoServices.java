package com.nik.ncompany.services;

import java.util.List;

import com.nik.ncompany.domain.Project;

public interface ProjectDaoServices {

	public Project findProjectById(int projId);

	public Project findProjectByName(String projName);

	public void insertProject(Project project);

	public void deleteProject(Project project);

	public int updateProject(int projId, Project project);

	public int getProjectCount();

	List<Project> getProjectList();

}
