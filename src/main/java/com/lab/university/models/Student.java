package com.lab.university.models;

import java.io.Serializable;
import java.util.ArrayList;

public class Student extends Person implements Serializable {
    private String ID;
    private ArrayList<Course> courses;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public Student(String ID, ArrayList<Course> courses) {
        super();
        this.ID = ID;
        this.courses = courses;
    }
}
