package com.lab.university.controllers;

import com.lab.university.models.AutoComplete;
import com.lab.university.models.Lecture;
import com.lab.university.models.MyAlert;
import com.lab.university.models.Navigation;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class UpdateLectureController implements Initializable {
    public TextField searchTextField;
    public TextField nameTextField;
    public TextField locationTextField;
    private static final ArrayList<Lecture> LECTURES = TeachingAssistantController.signedInTA.getCourse().getLectures();
    private static Lecture selectedLecture;
    public void searchLecture(ActionEvent actionEvent) {
        for (Lecture lecture: LECTURES) {
            if (lecture.getName().equalsIgnoreCase(searchTextField.getText())){
                selectedLecture = lecture;
                nameTextField.setText(lecture.getName());
                locationTextField.setText(lecture.getLocation());
                return;
            }
        }
        MyAlert.errorAlert(
                "Lecture not found",
                "Error",
                String.format("There is no lecture named %s", searchTextField.getText()));
    }

    public void updateLecture(ActionEvent actionEvent) {
        if (selectedLecture != null) {
            if (!(nameTextField.getText().isEmpty() || locationTextField.getText().isEmpty())){
                selectedLecture.setName(nameTextField.getText());
                selectedLecture.setLocation(locationTextField.getText());
                selectedLecture = null;
            } else {
                MyAlert.errorAlert("No enough data", "Error", "Fill all fields to continue");
            }
        } else {
            MyAlert.errorAlert("No lecture selected", "Error", "Select a lecture to update");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        AutoComplete.setAutoComplete(searchTextField, LECTURES);
    }

    public void goBack(ActionEvent actionEvent) throws IOException {
        Navigation.navigateTo(Navigation.TEACHING_ASSISTANT_FXML);
    }
}
