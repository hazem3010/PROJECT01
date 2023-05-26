package com.lab.university.controllers;

import com.lab.university.Main;
import com.lab.university.models.Course;
import com.lab.university.models.MyAlert;
import com.lab.university.models.Navigation;
import com.lab.university.models.TeachingAssistant;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Popup;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UpdateCourseController implements Initializable {
    public TextField searchBar;
    @FXML
    private AnchorPane rootPane;
   @FXML
    private TextField subjectField;
   @FXML
    private TextField bookNameField;
   @FXML
    private TextField placeField;
   @FXML
    private TextField instructorField;
    private Course selectedCourse;

   public void Back() throws IOException {
       Navigation.navigateTo(Navigation.SYSTEM_MANGER_FXML);
   }
   public void update(){
       if (selectedCourse != null){
           MyAlert.errorAlert("No course selected", "Error", "Search for a course and select it to update");
       }
       TeachingAssistant ta = null;
       for (TeachingAssistant ta_ : Main.TAs){
           if (ta_.getName().equalsIgnoreCase(instructorField.getText().trim())){
               ta = ta_;
               selectedCourse.setTA(ta_);
               break;
           }
       }
       if (ta!=null) {
           selectedCourse.setSubject(subjectField.getText());
           selectedCourse.setBook(bookNameField.getText());
           selectedCourse.setLocation(placeField.getText());
       }else {
           MyAlert.errorAlert("TA not found", "Error", String.format("There is no TA named %s", instructorField.getText()));
       }
   }

    public void search(ActionEvent actionEvent) {
        for (Course course : Main.courses){
            if (course.getSubject().equalsIgnoreCase(searchBar.getText().trim())){
                selectedCourse = course;
                subjectField.setText(selectedCourse.getSubject());
                bookNameField.setText(selectedCourse.getBook());
                placeField.setText(selectedCourse.getLocation());
                instructorField.setText((selectedCourse.getTA() != null)? selectedCourse.getTA().getName(): "");
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       //Instructor field suggestions
        {
            InstructorSuggestionsPopup(instructorField);
        }
        //Search bar suggestions
        {
            Popup searchSuggestionsPopup = new Popup();
            ListView<String> searchSuggestionsListView = new ListView<>();
            ObservableList<String> searchFilteredSuggestions = FXCollections.observableArrayList();

            searchBar.setOnKeyTyped(e -> {
                String enteredText = searchBar.getText().toLowerCase();
                if (enteredText.isEmpty()) {
                    searchSuggestionsPopup.hide();
                } else {
                    searchFilteredSuggestions.clear();
                    for (Course course: Main.courses) {
                        if (course.getSubject().toLowerCase().contains(searchBar.getText().trim().toLowerCase())) {
                            searchFilteredSuggestions.add(course.getSubject());
                        }
                    }
                    showSuggestionsPopup(searchSuggestionsPopup, searchSuggestionsListView, searchFilteredSuggestions, searchBar);
                }
            });

            hideOnEnterPressed(searchSuggestionsPopup, searchSuggestionsListView, searchBar);
        }
    }

    public void hideOnEnterPressed(Popup popup, ListView<String> listView, TextField textField) {
        listView.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER && !listView.getSelectionModel().isEmpty()) {
                textField.setText(listView.getSelectionModel().getSelectedItem());
                popup.hide();
            }
        });

        listView.setOnMouseClicked(e -> {
            searchBar.setText(listView.getSelectionModel().getSelectedItem());
            popup.hide();
        });
    }

    public void showSuggestionsPopup(Popup popup, ListView<String> listView, ObservableList<String> observableList, TextField textField) {
        if (observableList.size() > 1 || !(observableList.size() == 1 && observableList.get(0).equals(textField.getText()))) {
            AddCourseController.getSuggestionsItems(popup, listView, observableList, textField);
        } else {
            popup.hide();
        }
    }

    public void InstructorSuggestionsPopup(TextField textField) {
        Popup suggestionsPopup = new Popup();
        ListView<String> suggestionsListView = new ListView<>();
        ObservableList<String> filteredSuggestions = FXCollections.observableArrayList();

        textField.setOnKeyTyped(e -> {
            String enteredText = textField.getText().trim().toLowerCase();
            if (enteredText.isEmpty()) {
                suggestionsPopup.hide();
            } else {
                filteredSuggestions.clear();
                for (TeachingAssistant ta : Main.TAs) {
                    if (ta.getName().toLowerCase().contains(textField.getText().trim().toLowerCase())) {
                        filteredSuggestions.add(ta.getName());
                    }
                }
                showSuggestionsPopup(suggestionsPopup, suggestionsListView, filteredSuggestions, textField);
            }
        });

        hideOnEnterPressed(suggestionsPopup, suggestionsListView, textField);
    }
}
