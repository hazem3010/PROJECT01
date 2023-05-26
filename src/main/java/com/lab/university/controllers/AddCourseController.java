package com.lab.university.controllers;

import com.lab.university.models.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import com.lab.university.Main;
import javafx.stage.Popup;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddCourseController implements Initializable {
    public TextField instructorField;
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
        String instructor = instructorField.getText().trim();
        if (courseName.isEmpty() || bookName.isEmpty() || place.isEmpty()){
            MyAlert.errorAlert(
                    "No enough data",
                    "Error",
                    "Please fill all fields to continue");
            return;
        }
        Course course;
        if (instructor.isEmpty()) {
            course = new Course(courseName, bookName, place);
            Main.courses.add(course);
            clear();
        }else {
            TeachingAssistant ta = null;
            for (TeachingAssistant teachingAssistant: Main.TAs){
                if (teachingAssistant.getName().equals(instructor)){
                    ta = teachingAssistant;
                    break;
                }
            }

            if(ta != null){
                course = new Course(courseName, bookName, place, ta);
                Main.courses.add(course);
                clear();
            }else MyAlert.errorAlert("TA not found", "Error", String.format("There is no TA named %s", instructor));
        }

    }

    public void clear(){
        subjectField.clear();
        bookNameField.clear();
        classroomField.clear();
        instructorField.clear();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        AutoComplete.setAutoComplete(instructorField, Main.TAs);
    }
}