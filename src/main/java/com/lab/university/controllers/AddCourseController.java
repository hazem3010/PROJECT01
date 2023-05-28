package com.lab.university.controllers;

import com.lab.university.models.*;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import com.lab.university.Main;
import java.io.IOException;

public class AddCourseController {
    public AnchorPane rootPane;
    public TextField subjectField;
    public TextField bookNameField;
    public TextField classroomField;


    public void Back() throws IOException {
        Navigation.navigateTo(Navigation.SYSTEM_MANGER_FXML);
    }

    public void add(ActionEvent event) {
        String courseName = subjectField.getText().trim();
        String bookName = bookNameField.getText().trim();
        String place = classroomField.getText().trim();
        if (courseName.isEmpty() || bookName.isEmpty() || place.isEmpty()){
            MyAlert.errorAlert(
                    "No enough data",
                    "Error",
                    "Please fill all fields to continue");
            return;
        }
        Course course;
        course = new Course(courseName, bookName, place);
        Main.courses.add(course);
        clear();

    }

    public void clear(){
        subjectField.clear();
        bookNameField.clear();
        classroomField.clear();
    }
}