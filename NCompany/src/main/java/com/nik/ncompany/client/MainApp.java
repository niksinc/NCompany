package com.nik.ncompany.client;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nik.ncompany.domain.Employee;
import com.nik.ncompany.services.EmployeeDaoServiceImpl;

public class MainApp {
	
	public static void main(String[] args) {
		AbstractApplicationContext container = new ClassPathXmlApplicationContext("service.xml");
		
		EmployeeDaoServiceImpl employeeDaoServiceImpl;
		employeeDaoServiceImpl = (EmployeeDaoServiceImpl)container.getBean("employeeDaoServiceImpl");
		//Employee Doman Check
		//Employee employee = new Employee("Jay", "patilbhau", "pati@p.com", "1111");
		//employee.setEmpId(4);
		//employeeDaoServiceImpl.deleteEmployee(employee);
		//System.out.println(""+employeeDaoServiceImpl.findEmployeeByName(employee.getfName()));

	}

}
