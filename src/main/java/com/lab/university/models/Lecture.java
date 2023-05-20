package com.lab.university.models;

import java.util.ArrayList;
import java.util.Date;

public class Lecture {
    private Course course;
    private String location;
    private ArrayList<Student> attendance;
    private Date date;

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public ArrayList<Student> getAttendance() {
        return attendance;
    }

    public void setAttendance(ArrayList<Student> attendance) {
        this.attendance = attendance;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Lecture(Course course, String location, ArrayList<Student> attendance, Date date) {
        this.course = course;
        this.location = location;
        this.attendance = attendance;
        this.date = date;
    }
}
