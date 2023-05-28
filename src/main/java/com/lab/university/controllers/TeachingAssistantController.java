package com.lab.university.controllers;

import com.lab.university.models.Navigation;
import com.lab.university.models.TeachingAssistant;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class TeachingAssistantController {

    public AnchorPane rootPane;
    public static TeachingAssistant signedInTA;

    public void onAddStudent(ActionEvent actionEvent) throws IOException {
        Navigation.navigateTo(Navigation.ADD_STUDENT_FXML);
    }

    public void onUpdateStudent(ActionEvent actionEvent) throws IOException {
        Navigation.navigateTo(Navigation.UPDATE_STUDENT_FXML);
    }

    public void onRemoveStudent(ActionEvent actionEvent) throws IOException {
        Navigation.navigateTo(Navigation.REMOVE_STUDENT_FXML);
    }

    public void onAddLecture(ActionEvent actionEvent) throws IOException {
        Navigation.navigateTo(Navigation.ADD_LECTURE_FXML);
    }

    public void onUpdateLecture(ActionEvent actionEvent) throws IOException {
        Navigation.navigateTo(Navigation.UPDATE_LECTURE_FXML);
    }

    public void onRemoveLecture(ActionEvent actionEvent) throws IOException {
        Navigation.navigateTo(Navigation.REMOVE_LECTURE_FXML);
    }

    public void onAttendance(ActionEvent actionEvent) {
    }

    public void onReports(ActionEvent actionEvent) {
    }

    public void onBack(ActionEvent actionEvent) throws IOException {
        Navigation.navigateTo(Navigation.LOGIN_FXML);
    }
}
