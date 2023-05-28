package com.lab.university.models;

import java.io.Serializable;
import java.util.ArrayList;

public class Student extends Person implements Serializable, AutoCompletable {
    private String ID;
    private ArrayList<Course> courses;

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public Student(String name, byte gender, ArrayList<String> phoneNumbers, String address, String ID) {
        super(name, gender, phoneNumbers, address);
        this.ID = ID;
    }

    @Override
    public String toAutoComplete() {
        return getName();
    }
}
