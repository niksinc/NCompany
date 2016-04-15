package com.nik.ncompany.domain;

public class Project {

	private int projId, deptId;
	private String projName;
	private String StartDate, EndDate;

	public Project(String projName, int deptId, String StartDate) {
		super();
		this.deptId = deptId;
		this.projName = projName;
		this.StartDate = StartDate;
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
		return StartDate;
	}

	public void setStartDate(String StartDate) {
		this.StartDate = StartDate;
	}

	public String getEndDate() {
		return EndDate;
	}

	public void setEndDate(String EndDate) {
		this.EndDate = EndDate;
	}

}
