package com.nik.ncompany.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.nik.ncompany.domain.Project;

public final class ProjectRowMapper implements RowMapper<Project> {

	@Override
	public Project mapRow(ResultSet resultSet, int row) throws SQLException {
		String projName, startDate, endDate;
		int deptId, projId;
		Project project;

		projName = resultSet.getString("projName");
		deptId = resultSet.getInt("deptId");
		startDate = resultSet.getString("startDate");
		endDate = resultSet.getString("endDate");

		project = new Project(projName, deptId, startDate);
		project.setProjId(resultSet.getInt("projId"));
		project.setProjName(projName);
		project.setdeptId(deptId);
		project.setStartDate(startDate);
		project.setEndDate(endDate);

		return project;

	}

}
