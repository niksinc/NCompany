package com.nik.ncompany.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.nik.ncompany.dao.EmployeeDao;
import com.nik.ncompany.domain.Employee;

@Service("employeeDaoServiceImpl")
public class EmployeeDaoServiceImpl implements EmployeeDao {

	@Autowired
	@Qualifier("employeeDaojdbc")
	private EmployeeDao employeeDaojdbc;

	@Override
	public Employee findEmployeeById(int empId) {
		return employeeDaojdbc.findEmployeeById(empId);

	}

	@Override
	public Employee findEmployeeByName(String fName) {
		return employeeDaojdbc.findEmployeeByName(fName);

	}

	@Override
	public Employee findEmployeeByEmail(String email) {

		return employeeDaojdbc.findEmployeeByEmail(email);
	}

	@Override
	public void insertEmployee(Employee employee) {
		if (findEmployeeByEmail(employee.getEmail()) == null)
			employeeDaojdbc.insertEmployee(employee);
		else
			System.out.println("Employee is Already Exist with this email");

	}

	@Override
	public void deleteEmployee(Employee employee) {

		employeeDaojdbc.deleteEmployee(employee);
	}

	@Override
	public int updateEmployee(int empId, Employee employee) {

		return employeeDaojdbc.updateEmployee(empId, employee);
	}

	@Override
	public int getEmployeeCount() {

		return employeeDaojdbc.getEmployeeCount();

	}

	@Override
	public List<Employee> getEmployeeList() {
		return employeeDaojdbc.getEmployeeList();

	}

}
