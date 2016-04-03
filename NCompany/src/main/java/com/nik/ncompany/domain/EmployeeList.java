package com.nik.ncompany.domain;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class EmployeeList implements Serializable {
	private static final long serialVersionUID = 1L;
	// XmlElement sets the name of the entities
	@XmlElement(name = "employee")
	private List<Employee> sList;

	public EmployeeList() {
	}
	
	public List<Employee> getSList() {
		return sList;
	}

	public void setEmployeeList(List<Employee> newStudList) {
		this.sList = newStudList;
	}
	
	public int numEntries() {
		if (sList == null) return 0;
		return sList.size();
	}
	
	public Employee getEmployee(int idx) {
		return sList.get(idx);
	}
	
	public String toString() {
		String listStr;
		
		listStr = "EmployeeList{";
		for (Employee entry: sList) {
			listStr = listStr + "\n\t" + entry;
		}
		
		listStr = listStr + "\n}";
		return listStr;
	}
}