package com.lab.university.models;

import java.io.Serializable;
import java.util.ArrayList;

public class Lecture implements Serializable, AutoCompletable {
    private String name;
    private String location;
    private ArrayList<Student> attendingStudents;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Lecture(String location, String name) {
        this.location = location;
        this.name = name;
    }

    @Override
    public String toAutoComplete() {
        return name;
    }
}
