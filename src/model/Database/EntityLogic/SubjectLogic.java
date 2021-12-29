package model.Database.EntityLogic;

import model.Database.DataModel;
import model.Subject;

import java.util.ArrayList;

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
                dataModel.notifyTable();
                return true;
            }
        }
        return false;
    }
}
