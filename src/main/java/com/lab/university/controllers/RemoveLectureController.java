package com.lab.university.controllers;

import com.lab.university.models.AutoComplete;
import com.lab.university.models.Lecture;
import com.lab.university.models.MyAlert;
import com.lab.university.models.Navigation;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class RemoveLectureController implements Initializable {
    public TextField searchTextField;
    public Label searchResultLabel;
    private final ArrayList<Lecture> LECTURES = TeachingAssistantController.signedInTA.getCourse().getLectures();
    private Lecture selectedLecture;

    public void searchLecture(ActionEvent actionEvent) {
        for (Lecture lecture: LECTURES) {
            if (lecture.getName().equalsIgnoreCase(searchTextField.getText().trim())){
                searchResultLabel.setText(
                        String.format("Lecture Details: %s, %s", lecture.getName(), lecture.getLocation()));
                selectedLecture = lecture;
                return;
            }
        }
        MyAlert.errorAlert("Lecture not found", "Error", String.format("There is no lecture named %s", searchTextField.getText()));
    }

    public void removeLecture(ActionEvent actionEvent) {
        if (selectedLecture != null){
            String lectureName = selectedLecture.getName();
            LECTURES.remove(selectedLecture);
            selectedLecture = null;
            MyAlert.informationAlert(
                    "Remove success",
                    "Success",
                    String.format("Lecture %s removed successfully", lectureName));
            searchResultLabel.setText("");
        } else {
            MyAlert.errorAlert(
                    "No lectured selected.",
                    "Error",
                    "Select a lecture to remove.");
        }
    }

    public void goBack(ActionEvent actionEvent) throws IOException {
        Navigation.navigateTo(Navigation.TEACHING_ASSISTANT_FXML);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        AutoComplete.setAutoComplete(searchTextField, LECTURES);
    }
}
