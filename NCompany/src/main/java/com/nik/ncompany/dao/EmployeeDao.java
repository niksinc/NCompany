package com.nik.ncompany.dao;

import com.nik.ncompany.domain.Employee;

public interface EmployeeDao {

	public Employee findEmployeeById(int empId);
	public Employee findEmployeeByName(String fName);
	public Employee findEmployeeByEmail(String email); 
	public void insertEmployee(Employee employee);
	public void deleteEmployee(Employee employee);
	public int updateEmployee(int empId, Employee employee);
	public int getEmployeeCount();
	

}
