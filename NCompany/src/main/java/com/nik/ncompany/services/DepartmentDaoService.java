package com.nik.ncompany.services;

import java.util.List;

import com.nik.ncompany.domain.Department;

public interface DepartmentDaoService {
	public Department findDepartmentById(int deptId);
	public Department findDepartmentByName(String deptName);
	public void insertDepartment(Department department);
	public void deleteDepartment(Department department);
	public int updateDepartment(int deptId, Department department);
	public int getDepartmentCount();
	List<Department> getDepartmentList();

}
