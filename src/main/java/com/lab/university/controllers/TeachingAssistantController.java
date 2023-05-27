package com.lab.university.controllers;

import com.lab.university.models.Navigation;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class TeachingAssistantController {

    public AnchorPane rootPane;

    public void onAddStudent(ActionEvent actionEvent) throws IOException {
        Navigation.navigateTo(Navigation.ADD_STUDENT_FXML);
    }

    public void onUpdateStudent(ActionEvent actionEvent) {
    }

    public void onRemoveStudent(ActionEvent actionEvent) {
    }

    public void onAddLecture(ActionEvent actionEvent) {
    }

    public void onUpdateLecture(ActionEvent actionEvent) {
    }

    public void onRemoveLecture(ActionEvent actionEvent) {
    }

    public void onAttendance(ActionEvent actionEvent) {
    }

    public void onReports(ActionEvent actionEvent) {
    }

    public void onBack(ActionEvent actionEvent) {
    }
}
