package com.nik.ncompany.domain;

public class Project {

	private int projId, deptId;
	private String projName;
	private String projStartDate, projEndDate;

	public Project(String projName, int deptId, String projStartDate) {
		super();
		this.deptId = deptId;
		this.projName = projName;
		this.projStartDate = projStartDate;
	}

	public int getProjId() {
		return projId;
	}

	public void setProjId(int projId) {
		this.projId = projId;
	}

	public int getdeptId() {
		return deptId;
	}

	public void setdeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getProjName() {
		return projName;
	}

	public void setProjName(String projName) {
		this.projName = projName;
	}

	public String getStartDate() {
		return projStartDate;
	}

	public void setStartDate(String projStartDate) {
		this.projStartDate = projStartDate;
	}

	public String getEndDate() {
		return projEndDate;
	}

	public void setEndDate(String projEndDate) {
		this.projEndDate = projEndDate;
	}

}
