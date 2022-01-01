package model.Database.EntityLogic;

import model.Database.DataModel;
import model.Professor;
import model.Student;
import model.Subject;

import java.util.ArrayList;
import java.util.Iterator;

public class SubjectLogic {
    private DataModel dataModel;

    public SubjectLogic(DataModel dm) {
        dataModel = dm;
    }

    public void addSubjectToList(Subject newSubject) {
        ArrayList<Subject> subjects = dataModel.getSubjects();
        subjects.add(newSubject);
        dataModel.notifyTable();
    }

    public Subject getSubjectById(String id) {
        ArrayList<Subject> subjects = dataModel.getSubjects();
        for (Subject subj : subjects) {
            if (subj.getSubjectId().equals(id)) {
                return subj;
            }
        }
        return null;
    }

    public boolean removeSubjectById(String id) {
        // Treba dodati uklanjanje svih zavisnosti entiteta u drugim listama
        ArrayList<Subject> subjects = dataModel.getSubjects();
        for (Subject subject : subjects) {
            if (subject.getSubjectId().equals(id)) {
                subjects.remove(subject);
                removeSubjectDependencies(id);
                dataModel.notifyTable();
                return true;
            }
        }
        return false;
    }

    public void removeSubjectDependencies(String id) {
        removeSubjectFromStudents(id);
        removeSubjectFromProfessors(id);
    }

    public void removeSubjectFromStudents(String id) {
        ArrayList<Student> students = dataModel.getStudents();
        for(Student student: students) {
            ArrayList<Subject> passed = student.getPassedSubjects();
            ArrayList<Subject> failed = student.getFailedSubjects();
            for(Iterator<Subject> subIt = passed.iterator(); subIt.hasNext();) {
                Subject subject = subIt.next();
                if (subject.getSubjectId().equals(id))
                    subIt.remove();
            }
            for(Iterator<Subject> subIt = failed.iterator(); subIt.hasNext();) {
                Subject subject = subIt.next();
                if (subject.getSubjectId().equals(id))
                    subIt.remove();
            }
        }
    }

    public void removeSubjectFromProfessors(String id) {
        ArrayList<Professor> professors = dataModel.getProfessors();
        printProfessorsSubjectsSize();
        for(Professor professor: professors) {
            ArrayList<Subject> profSubjects = professor.getSubjects();
            for(Iterator<Subject> its = profSubjects.iterator(); its.hasNext();) {
                Subject subject = its.next();
                if(subject.getSubjectId().equals(id)) {
                    its.remove();
                }
            }

        }
        printProfessorsSubjectsSize();

    }

    private void printProfessorsSubjectsSize() {
        for(Professor professor: dataModel.getProfessors()) {
            System.out.println(professor.getSubjects().size());
        }

    }
}
