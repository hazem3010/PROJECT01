package com.lab.university.models;

import java.util.ArrayList;

public class Course {
    private String subject ;
    private String book ;
    private String location;
    private Student[] students;
    private TeachingAssistant TA;
    private ArrayList<Lecture> lectures;

    public Course(String subject, String book, String location, TeachingAssistant TA) {
        this.subject = subject;
        this.book = book;
        this.location = location;
        this.TA = TA;
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

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public TeachingAssistant getTA() {
        return TA;
    }

    public void setTA(TeachingAssistant TA) {
        this.TA = TA;
    }

    public ArrayList<Lecture> getLectures() {
        return lectures;
    }

    public void setLectures(ArrayList<Lecture> lectures) {
        this.lectures = lectures;
    }
}
