package com.lab.university.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Course implements Serializable, AutoCompletable {
    private String subject ;
    private String book ;
    private String location;
    private Map<Student, Integer> students = new LinkedHashMap<>();
    private ArrayList<Lecture> lectures = new ArrayList<>();


    public Course(String subject, String book, String location) {
        this.subject = subject;
        this.book = book;
        this.location = location;
    }

    public Course() {
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Map<Student, Integer> getStudents() {
        return students;
    }

    public void setStudents(HashMap<Student, Integer> students) {
        this.students = students;
    }

    public ArrayList<Lecture> getLectures() {
        return lectures;
    }

    public void setLectures(ArrayList<Lecture> lectures) {
        this.lectures = lectures;
    }

    @Override
    public String toAutoComplete() {
        return getSubject();
    }
}
