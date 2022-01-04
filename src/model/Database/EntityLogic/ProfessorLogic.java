package model.Database.EntityLogic;

import model.Database.DataModel;
import model.Professor;
import model.Subject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

public class ProfessorLogic {
    private DataModel dataModel;
    public ProfessorLogic(DataModel dm) {
        dataModel = dm;
    }

    public void addProfessorToList(Professor newProfessor) {
        ArrayList<Professor> professors = dataModel.getProfessors();
        professors.add(newProfessor);
        dataModel.notifyTable();
    }

    public Professor getProfessorById(String id) {
        ArrayList<Professor> professors = dataModel.getProfessors();
        for (Professor prof : professors) {
            if (prof.getIdNumber().equals(id)) {
                return prof;
            }
        }

        return null;
    }

    public void setEditedProfessor(String oldId, Professor professorNewInfo) {
        ArrayList<Professor> professors = dataModel.getProfessors();
        for (int i = 0; i < professors.size(); i++) {
            if (professors.get(i).getIdNumber().equals(oldId)) {
                professors.get(i).setFirstName(professorNewInfo.getFirstName());
                professors.get(i).setLastName(professorNewInfo.getLastName());
                professors.get(i).setBirthDay(professorNewInfo.getBirthDay());
                professors.get(i).setAddress(professorNewInfo.getAddress());
                professors.get(i).setPhoneNumber(professorNewInfo.getPhoneNumber());
                professors.get(i).setEmailAddress(professorNewInfo.getEmailAddress());
                professors.get(i).setOfficeAddress(professorNewInfo.getOfficeAddress());
                professors.get(i).setIdNumber(professorNewInfo.getIdNumber());
                professors.get(i).setTitle(professorNewInfo.getTitle());
                professors.get(i).setWorkingYears(professorNewInfo.getWorkingYears());
                dataModel.notifyTable();
            }
        }
    }
    
    public void addSubjectToProfessor(String id,Subject subject) {
    	ArrayList<Professor> professors = dataModel.getProfessors();
    	for(Professor professor : professors) {
    		if(professor.getIdNumber().equals(id)) {
    			professor.addSubject(subject);
    			dataModel.notifyEditTable();
    		}
    	}
    }
    
    public ArrayList<Subject> getNewSubjectsForProfessor(String id){
    	Professor professor = getProfessorById(id);
    	ArrayList<Subject> subjects = dataModel.getSubjects();
    	ArrayList<Subject> professorSubjects = professor.getSubjects();
    	ArrayList<Subject> subjectsForAdding = new ArrayList<>();
    	
    	for(Subject subject : subjects) {
    		if(!isSubjectFoundInList(subject.getSubjectId(), professorSubjects))
    			subjectsForAdding.add(subject);
    	}
    	System.out.println(subjectsForAdding);
    	return subjectsForAdding;
    }
    
    public boolean isSubjectFoundInList(String subjectId, ArrayList<Subject> subjects) {
        for (Subject subject : subjects) {
            if (subject.getSubjectId().equals(subjectId))
                return true;
        }
        return false;
    }

    public boolean removeProfessorById(String id) {
        // Treba dodati uklanjanje svih zavisnosti entiteta u drugim listama
        ArrayList<Professor> professors = dataModel.getProfessors();
        for (Professor professor : professors) {
            if (professor.getIdNumber().equals(id)) {
                professors.remove(professor);
                removeProfessorDependencies(id);
                dataModel.notifyTable();
                return true;
            }
        }

        return false;
    }

    private void removeProfessorDependencies(String id) {
        removeProfessorFromSubjects(id);
    }

    private void removeProfessorFromSubjects(String id) {
        ArrayList<Subject> subjects = dataModel.getSubjects();
        for (Iterator<Subject> subIt = subjects.iterator(); subIt.hasNext(); ) {
            Subject subject = subIt.next();

            if (subject.getProfessor() == null) continue;
            if (subject.getProfessor().getIdNumber().equals(id)) {
                subject.setProfessor(null);
            }
        }
    }

    public String getProfessorIdFromEmail(String email) {
        ArrayList<Professor> professors = dataModel.getProfessors();
        for (Professor professor : professors) {
            if (professor.getEmailAddress().equals(email)) {
                return professor.getIdNumber();
            }
        }
        return null;
    }
    
    public boolean removeSubjectFromProfessorSubjects(String subjectId,String professorId) {
    	for(Iterator<Professor> professorIt = dataModel.getProfessors().iterator();professorIt.hasNext();) {
    		Professor professor = professorIt.next();
    		if(professor.getIdNumber().equals(professorId)) {
    			professor.removeSubject(subjectId);
    			dataModel.notifyEditTable();
    			return true;
    		}
    	}
    	return false;
    }

    public ArrayList<Professor> filterProfessorForHeadOfDep() {
        ArrayList<Professor> filtered = new ArrayList<>();
        ArrayList<Professor> professors = dataModel.getProfessors();
        for(Professor professor: professors) {
            if(professor.getWorkingYears() > 5 && (professor.getTitle().toLowerCase().equals("redovni profesor")
                    || professor.getTitle().toLowerCase(Locale.ROOT).equals("vanredni profesor"))) {
                filtered.add(professor);
            }
        }

        return filtered;
    }

}
