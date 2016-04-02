package com.nik.ncompany.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.nik.ncompany.domain.Employee;



public class EmployeeRowMapper implements RowMapper<Employee>{

	public Employee mapRow(ResultSet resultSet, int row) throws SQLException {
		String fName;
		String lName;
		String phoneNumber;
		String email;
		Employee employee;
		
		
		fName = resultSet.getString("fName");
		lName = resultSet.getString("lName");
		email = resultSet.getString("email");
		phoneNumber = resultSet.getString("phoneNumber");
		
		employee = new Employee(fName, lName, email, phoneNumber);
		employee.setEmpId(resultSet.getInt("empId"));
		employee.setfName(fName);
		employee.setlName(lName);
		employee.setEmail(email);
		employee.setPhoneNumber(phoneNumber);
	
		return employee;
	}

}
