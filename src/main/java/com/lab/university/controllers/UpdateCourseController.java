package com.lab.university.controllers;

import com.lab.university.Main;
import com.lab.university.models.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
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
    private Course selectedCourse;

   public void Back() throws IOException {
       Navigation.navigateTo(Navigation.SYSTEM_MANGER_FXML);
   }
   public void update(){
       if (selectedCourse == null){
           MyAlert.errorAlert("No courseField selected", "Error", "Search for a courseField and select it to update");
       }
       selectedCourse.setSubject(subjectField.getText());
       selectedCourse.setBook(bookNameField.getText());
       selectedCourse.setLocation(placeField.getText());
   }

    public void search(ActionEvent actionEvent) {
        for (Course course : Main.courses){
            if (course.getSubject().equalsIgnoreCase(searchBar.getText().trim())){
                selectedCourse = course;
                subjectField.setText(selectedCourse.getSubject());
                bookNameField.setText(selectedCourse.getBook());
                placeField.setText(selectedCourse.getLocation());
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        AutoComplete.setAutoComplete(searchBar, Main.courses);
    }
}
