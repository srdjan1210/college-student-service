package model.database.entity_logic;

import model.database.DataModel;
import model.Department;
import model.Professor;

import java.util.ArrayList;
import java.util.Locale;

public class DepartmentLogic {
    private DataModel dataModel;

    public DepartmentLogic(DataModel dataModel) {
        this.dataModel = dataModel;
    }

    public Department getDepartmentById(String id) {
        ArrayList<Department> departments = dataModel.getDepartments();
        System.out.println(departments);
        for (Department department : departments)
            if (department.getDepartmentId().equals(id)) return department;
        return null;
    }
    public ArrayList<Professor> filterProfessorForHeadOfDep(String depId) {
        ArrayList<Professor> filtered = new ArrayList<>();
        ArrayList<Professor> professors = dataModel.getProfessors();

        for(Professor professor : professors) {
            if(professor.getDepartment().equals(depId) && professor.getWorkingYears() > 5
                && (professor.getTitle().toLowerCase().equals("redovni_profesor") || professor.getTitle().toLowerCase().equals("vanredni_profesor"))) {
                filtered.add(professor);
            }
        }

        return filtered;
    }

    public void editDepartment(Department department, String oldDepId) {
        Department dep = getDepartmentById(oldDepId);
        dep.setDepartmentId(department.getDepartmentId());
        dep.setDepartmentName(department.getDepartmentName());
        dep.setHeadOfTheDepartment(department.getHeadOfTheDepartment());
    }
}
