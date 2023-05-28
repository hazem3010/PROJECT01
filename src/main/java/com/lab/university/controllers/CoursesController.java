package com.lab.university.controllers;

import com.lab.university.Main;
import com.lab.university.models.AutoComplete;
import com.lab.university.models.Course;
import com.lab.university.models.MyAlert;
import com.lab.university.models.Navigation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CoursesController implements Initializable {

    public static String backPath;
    public static ArrayList<Course> courses;
    public AnchorPane rootPane;
    public ListView<String> coursesListView;
    public TextField courseField;

    public void addCourse(ActionEvent actionEvent) {
        if (!courseField.getText().isEmpty()) {
            for (Course course: Main.courses){
                if (course.getSubject().equalsIgnoreCase(courseField.getText().trim())){
                    courses.add(course);
                    showViewList();
                    return;
                }
            }
            MyAlert.errorAlert("Course not found", "Error", String.format("There is no course with subject %s", courseField.getText()));

        } else MyAlert.errorAlert("Empty field", "Error", "Enter a phone number to add");
    }

    private void showViewList() {
        coursesListView.getItems().clear();
        ObservableList<Course> data = FXCollections.observableArrayList(courses);
        AutoComplete.setAutoComplete(courseField, Main.courses);
        for (Course course: data){
            coursesListView.getItems().add(course.getSubject());
        }
    }

    public void removeCourse(ActionEvent actionEvent) {
        if (!courseField.getText().isEmpty()) {
            for (Course course: courses){
                if (course.getSubject().equalsIgnoreCase(courseField.getText().trim())){
                    courses.remove(course);
                    showViewList();
                    return;
                }
            }
        } else MyAlert.errorAlert("Empty field", "Error", "Enter a phone number to remove");
    }

    public void goBack(ActionEvent actionEvent) throws IOException {
        Navigation.navigateTo(backPath);
        courses = null;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showViewList();
    }


}
