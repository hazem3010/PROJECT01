package com.lab.university.controllers;

import com.lab.university.Main;
import com.lab.university.models.AutoComplete;
import com.lab.university.models.Course;
import com.lab.university.models.MyAlert;
import com.lab.university.models.Navigation;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

 public class RemoveCourseController implements Initializable {

    public AnchorPane rootPane;
    public javafx.scene.control.TextField textField;

    public void onBack(ActionEvent actionEvent) throws IOException {
        Navigation.navigateTo(Navigation.SYSTEM_MANGER_FXML);
    }

    public void onRemove(ActionEvent actionEvent) {
        for (Course course: Main.courses) {
            if (course.getSubject().equalsIgnoreCase(textField.getText())) Main.courses.remove(course);
            MyAlert.informationAlert("Course deleted!", "Success", String.format("Course %s deleted successfully", course.getSubject()));
            return;
        }
        MyAlert.errorAlert("Course not found", "Error", String.format("There is no course named %S", textField.getText()));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        AutoComplete.setAutoComplete(textField, Main.courses);
    }
}
