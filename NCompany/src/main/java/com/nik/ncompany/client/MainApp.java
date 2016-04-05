package com.nik.ncompany.client;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nik.ncompany.domain.Project;
import com.nik.ncompany.services.DepartmentDaoServiceImpl;
import com.nik.ncompany.services.EmployeeDaoServiceImpl;
import com.nik.ncompany.services.ProjectDaoServiceImpl;

public class MainApp {

	public static void main(String[] args) {
		AbstractApplicationContext container = new ClassPathXmlApplicationContext("service.xml");

		EmployeeDaoServiceImpl employeeDaoServiceImpl;
		employeeDaoServiceImpl = (EmployeeDaoServiceImpl) container.getBean("employeeDaoServiceImpl");
		// Employee Doman Check
		// Employee employee = new Employee("Jay", "patilbhau", "pati@p.com",
		// "1111");
		// employee.setEmpId(4);
		// employeeDaoServiceImpl.deleteEmployee(employee);
		// System.out.println(""+employeeDaoServiceImpl.findEmployeeByName(employee.getfName()));

		DepartmentDaoServiceImpl departmentDaoServiceImpl;
		departmentDaoServiceImpl = (DepartmentDaoServiceImpl) container.getBean("departmentDaoServiceImpl");

		// Department department = new Department("Testing", "Fremont");

		// departmentDaoServiceImpl.deleteDepartment(departmentDaoServiceImpl.findDepartmentById(5));
		// System.out.println(departmentDaoServiceImpl.updateDepartment(4,
		// department));

		ProjectDaoServiceImpl projectDaoServiceImpl;
		projectDaoServiceImpl = (ProjectDaoServiceImpl) container.getBean("projectDaoServiceImpl");
		// System.out.println(projectDaoServiceImpl.getProjectCount());
		// Project project =new Project("myproj", 1, new java.util.Date());

		Project project = new Project("myproj", 1, "2016-12-12");
		// projectDaoServiceImpl.updateProject(14, project);
		projectDaoServiceImpl.insertProject(project);
		// (projectDaoServiceImpl.findProjectById(2).getprojStartDate())
		// System.out.println();

	}

}
