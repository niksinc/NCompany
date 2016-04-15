package com.nik.ncompany.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.nik.ncompany.dao.DepartmentDao;
import com.nik.ncompany.domain.Department;

@Service("departmentDaoServiceImpl")
public class DepartmentDaoServiceImpl implements DepartmentDaoService {

	@Autowired
	@Qualifier("departmentDaojdbc")
	private DepartmentDao departmentDaojdbc;

	@Override
	public Department findDepartmentById(int deptId) {

		return departmentDaojdbc.findDepartmentById(deptId);
	}

	@Override
	public Department findDepartmentByName(String deptName) {

		return departmentDaojdbc.findDepartmentByName(deptName);
	}

	@Override
	public void insertDepartment(Department department) {
		departmentDaojdbc.insertDepartment(department);

	}

	@Override
	public void deleteDepartment(Department department) {
		departmentDaojdbc.deleteDepartment(department);

	}

	@Override
	public int updateDepartment(int deptId, Department department) {
		// TODO Auto-generated method stub
		return departmentDaojdbc.updateDepartment(deptId, department);
	}

	@Override
	public int getDepartmentCount() {

		return departmentDaojdbc.getDepartmentCount();
	}

	@Override
	public List<Department> getDepartmentList() {
		return departmentDaojdbc.getDepartmentList();
		
	}

}
