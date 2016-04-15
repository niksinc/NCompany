package com.nik.ncompany.domain;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

	@XmlRootElement
	public class DepartmentList implements Serializable {
		private static final long serialVersionUID = 1L;
		// XmlElement sets the name of the entities
		@XmlElement(name = "department")
		private List<Department> sList;

		public DepartmentList() {
		}

		public List<Department> getSList() {
			return sList;
		}

		public void setDepartmentList(List<Department> newStudList) {
			this.sList = newStudList;
		}

		public int numEntries() {
			if (sList == null)
				return 0;
			return sList.size();
		}

		public Department getDepartment(int idx) {
			return sList.get(idx);
		}

		@Override
		public String toString() {
			String listStr;

			listStr = "DepartmentList{";
			for (Department entry : sList) {
				listStr = listStr + "\n\t" + entry;
			}

			listStr = listStr + "\n}";
			return listStr;
		}
	}

