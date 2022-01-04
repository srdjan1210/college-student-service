package model.Database.DTOs;

import model.Subject;

import java.util.ArrayList;

public class PassedSubject {
    private String id;
    private String subjectId;

    public PassedSubject(String id, String subject) {
        this.id = id;
        this.subjectId = subject;
    }

    public String getId() {
        return id;
    }

    public String getSubject() {
        return subjectId;
    }

    @Override
    public String toString() {
        return id + "," + subjectId;
    }
}
