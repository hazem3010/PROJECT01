package com.lab.university.models;

public class TeachingAssistant extends User {
    private Course[] courses;

    public Course[] getCourses() {
        return courses;
    }

    public void setCourses(Course[] courses) {
        this.courses = courses;
    }

    public TeachingAssistant(Course[] courses) {
        super();
        this.courses = courses;
    }
}
