package com.nik.ncompany.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.nik.ncompany.dao.EmployeeDao;
import com.nik.ncompany.domain.Employee;

@Service("employeeDaoServiceImpl")
public class EmployeeDaoServiceImpl implements EmployeeDaoService {

	@Autowired
	@Qualifier("employeeDaojdbc")
	private EmployeeDao employeeDaojdbc;

	@Override
	public Employee findEmployeeById(int empId) {
		// TODO Auto-generated method stub
		return employeeDaojdbc.findEmployeeById(empId);
		
	}

	@Override
	public Employee findEmployeeByName(String fName) {
		// TODO Auto-generated method stub
		return employeeDaojdbc.findEmployeeByName(fName);
		
	}

	@Override
	public Employee findEmployeeByEmail(String email) {
		// TODO Auto-generated method stub
		return employeeDaojdbc.findEmployeeByEmail(email);
		
	}

	@Override
	public void addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		employeeDaojdbc.insertEmployee(employee);
		
	}

	@Override
	public void deleteEmployee(Employee employee) {
		// TODO Auto-generated method stub
		employeeDaojdbc.deleteEmployee(employee);
		
	}

	@Override
	public int updateEmployee(int empId, Employee employee) {
		// TODO Auto-generated method stub
		return employeeDaojdbc.updateEmployee(empId, employee);
		
	}

	@Override
	public int getEmployeeCount() {
		// TODO Auto-generated method stub
		
		return employeeDaojdbc.getEmployeeCount();
	}

	@Override
	public List<Employee> getEmployeeList() {
		// TODO Auto-generated method stub
		return employeeDaojdbc.getEmployeeList();
	}

	
}
