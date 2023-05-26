package com.lab.university.controllers;

import com.lab.university.models.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
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
        Popup suggestionsPopup = new Popup();
        ListView<String> suggestionsListView = new ListView<>();
        suggestionsListView.setPrefHeight(100);
        suggestionsListView.setMaxWidth(150);
        suggestionsListView.getStyleClass().add("suggestions-list");
        ObservableList<String> filteredSuggestions = FXCollections.observableArrayList();

        instructorField.setOnKeyTyped(e -> {
            String enteredText = instructorField.getText().toLowerCase();
            if (enteredText.isEmpty()) {
                suggestionsPopup.hide();
            } else {
                filteredSuggestions.clear();
                for (TeachingAssistant ta: Main.TAs) {
                    if (ta.getName().toLowerCase().contains(instructorField.getText().trim().toLowerCase())) {
                        filteredSuggestions.add(ta.getName());
                    }
                }
                if (!filteredSuggestions.isEmpty()) {
                    getSuggestionsItems(suggestionsPopup, suggestionsListView, filteredSuggestions, instructorField);
                } else {
                    suggestionsPopup.hide();
                }
            }
        });

        suggestionsListView.setOnMouseClicked(e -> {
            if (!suggestionsListView.getSelectionModel().isEmpty()) {
                instructorField.setText(suggestionsListView.getSelectionModel().getSelectedItem());
                suggestionsPopup.hide();
            }
        });
    }

    public static void getSuggestionsItems(Popup popup, ListView<String> listView, ObservableList<String> observableList, TextField textField) {
        listView.setItems(observableList);
        listView.getSelectionModel().clearSelection();

        double listViewHeight = observableList.size() * 24 + 2;
        listView.setPrefHeight(listViewHeight);

        popup.getContent().clear();
        popup.getContent().add(listView);

        Bounds bounds = textField.localToScreen(textField.getBoundsInLocal());
        popup.show(textField, bounds.getMinX(), bounds.getMaxY());
    }
}