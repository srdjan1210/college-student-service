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
        for (Department department : dataModel.getDepartments())
            if (department.getDepartmentId().equals(id)) return department;
        return null;
    }
    public ArrayList<Professor> filterProfessorForHeadOfDep(String depId) {
        ArrayList<Professor> filtered = new ArrayList<>();
        ArrayList<Professor> professors = dataModel.getProfessors();
        for (Professor professor : professors) {
            if (professor.getWorkingYears() > 5 && !professorIsHead(professor.getIdNumber(), depId)
                    && professor.getTitle().toLowerCase().equals("redovni profesor")
                    || professor.getTitle().toLowerCase(Locale.ROOT).equals("vanredni profesor")) {
                filtered.add(professor);
            }
        }

        return filtered;
    }

    public boolean professorIsHead(String professorId, String depId) {
        ArrayList<Department> departments = dataModel.getDepartments();
        for(Department department: departments) {
            if(department.getHeadOfTheDepartment() == null) continue;
            if(department.getHeadOfTheDepartment().getIdNumber().equals(professorId) && department.getDepartmentId().equals(depId)) return false;
            if(department.getHeadOfTheDepartment().getIdNumber().equals(professorId)) return true;
        }
        return false;
    }

    public void editDepartment(Department department, String oldDepId) {
        Department dep = getDepartmentById(oldDepId);
        dep.setDepartmentId(department.getDepartmentId());
        dep.setDepartmentName(department.getDepartmentName());
        dep.setHeadOfTheDepartment(department.getHeadOfTheDepartment());
    }
}
