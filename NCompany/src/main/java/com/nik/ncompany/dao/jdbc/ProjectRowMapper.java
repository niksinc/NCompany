package com.nik.ncompany.dao.jdbc;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.nik.ncompany.domain.Department;
import com.nik.ncompany.domain.Project;

public final class ProjectRowMapper implements RowMapper<Project> {

	@Override
	public Project mapRow(ResultSet resultSet, int row) throws SQLException {
		String projName;
		int deptId,projId;
		Date projStartDate;
		Date projEndDate;
		Project project;
		
		projName = resultSet.getString("projName");
		deptId = resultSet.getInt("deptId");
		projStartDate =resultSet.getDate("startDate");
		projEndDate =resultSet.getDate("projEndDate");
		projEndDate = resultSet.getDate("projEndDate");
		
		project = new Project(projName, deptId,projStartDate);
		project.setProjId(resultSet.getInt("projId"));
		project.setProjName(projName);
		project.setprojStartDate(projStartDate);
		project.setprojEndDate(projEndDate);
		
		return project;
	}

}
