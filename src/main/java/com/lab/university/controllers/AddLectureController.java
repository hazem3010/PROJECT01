package com.lab.university.controllers;

import com.lab.university.models.Lecture;
import com.lab.university.models.MyAlert;
import com.lab.university.models.Navigation;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddLectureController implements Initializable {
    public TextField nameTextField;
    public TextField locationTextField;

    public void addLecture(ActionEvent actionEvent) {
        if (!(locationTextField.getText().isEmpty() || nameTextField.getText().isEmpty())) {
            TeachingAssistantController.signedInTA.getCourse().getLectures().add(
                    new Lecture(locationTextField.getText(), nameTextField.getText()));
            MyAlert.informationAlert("Lecture Added successfully", "Success", "");
        } else {
            MyAlert.errorAlert(
                    "No enough information",
                    "Error",
                    "Fill all fields to continue");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        locationTextField.setText(TeachingAssistantController.signedInTA.getCourse().getLocation());
    }

    public void goBack(ActionEvent actionEvent) throws IOException {
        Navigation.navigateTo(Navigation.TEACHING_ASSISTANT_FXML);
    }
}
