package com.lab.university.models;

import java.io.Serializable;
import java.util.ArrayList;

public class TeachingAssistant extends User implements Serializable, AutoCompletable {
    private Course course;

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public TeachingAssistant() {
    }

    public TeachingAssistant(String userName, String password, String name, byte gender, ArrayList<String> phone, String address) {
        super(userName, password, name, gender, phone, address);
    }

    public TeachingAssistant(String userName, String password, String name, byte gender, ArrayList<String> phone, String address, Course course) {
        super(userName, password, name, gender, phone, address);
        this.course = course;
    }

    @Override
    public String toAutoComplete() {
        return getName();
    }
}
