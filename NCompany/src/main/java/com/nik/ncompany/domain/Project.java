package com.nik.ncompany.domain;

import java.sql.Date;

public class Project {
	
	private int projId,departmentId;
	private String projName;
	private Date projStartDate,projEndDate;
	
	public Project(String projName,int departmentId,  Date projStartDate) {
		super();
		this.departmentId = departmentId;
		this.projName = projName;
		this.projStartDate = projStartDate;
	}
	
	public int getProjId() {
		return projId;
	}
	public void setProjId(int projId) {
		this.projId = projId;
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public String getProjName() {
		return projName;
	}
	public void setProjName(String projName) {
		this.projName = projName;
	}
	public Date getprojStartDate() {
		return projStartDate;
	}
	public void setprojStartDate(Date projStartDate) {
		this.projStartDate = projStartDate;
	}
	public Date getprojEndDate() {
		return projEndDate;
	}
	public void setprojEndDate(Date projEndDate) {
		this.projEndDate = projEndDate;
	}
	

}
