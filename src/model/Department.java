package model;

import java.util.ArrayList;

public class Department {
	private String departmentId;
	private String departmentName;
	private Professor headOfTheDepartment;
	private ArrayList<Professor> professorsList;
	
	public Department(String departmentId, String departmentName, Professor headOfTheDepartment,
			ArrayList<Professor> professorsList) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.headOfTheDepartment = headOfTheDepartment;
		this.professorsList = professorsList;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Professor getHeadOfTheDepartment() {
		return headOfTheDepartment;
	}

	public void setHeadOfTheDepartment(Professor headOfTheDepartment) {
		this.headOfTheDepartment = headOfTheDepartment;
	}

	public ArrayList<Professor> getProfessorsList() {
		return professorsList;
	}

	public void setProfessorsList(ArrayList<Professor> professorsList) {
		this.professorsList = professorsList;
	}
	
	
	
}
