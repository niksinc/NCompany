package com.nik.ncompany.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.nik.ncompany.domain.Department;

public class DepartmentRowMapper implements RowMapper<Department> {

	@Override
	public Department mapRow(ResultSet resultSet, int row) throws SQLException {
		String deptName, location;
		int deptId;
		Department deparment;
		deptName = resultSet.getString("deptName");
		location = resultSet.getString("location");

		deparment = new Department(deptName, location);
		deparment.setDeptId(resultSet.getInt("deptId"));
		deparment.setDeptName(deptName);
		deparment.setLocation(location);
		return deparment;

	}

}
