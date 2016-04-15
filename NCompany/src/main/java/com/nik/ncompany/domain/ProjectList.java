package com.nik.ncompany.domain;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ProjectList implements Serializable {
	private static final long serialVersionUID = 1L;
	// XmlElement sets the name of the entities
	@XmlElement(name = "employee")
	private List<Project> sList;

	public ProjectList() {
	}

	public List<Project> getSList() {
		return sList;
	}

	public void setProjectList(List<Project> newStudList) {
		this.sList = newStudList;
	}

	public int numEntries() {
		if (sList == null)
			return 0;
		return sList.size();
	}

	public Project getProject(int idx) {
		return sList.get(idx);
	}

	@Override
	public String toString() {
		String listStr;

		listStr = "ProjectList{";
		for (Project entry : sList) {
			listStr = listStr + "\n\t" + entry;
		}

		listStr = listStr + "\n}";
		return listStr;
	}
}