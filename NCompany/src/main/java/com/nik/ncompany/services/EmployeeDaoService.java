package com.nik.ncompany.services;

import java.util.List;

import com.nik.ncompany.domain.Employee;

public interface EmployeeDaoService {

	public Employee findEmployeeById(int empId);

	public Employee findEmployeeByName(String fName);

	public Employee findEmployeeByEmail(String email);

	public void addEmployee(Employee employee);

	public void deleteEmployee(Employee employee);

	public int updateEmployee(long id, Employee employee);

	public int getEmployeeCount();

	public List<Employee> getEmployeeList();

}
