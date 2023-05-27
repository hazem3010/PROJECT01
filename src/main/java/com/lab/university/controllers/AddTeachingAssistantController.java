package com.lab.university.controllers;

import com.lab.university.Main;
import com.lab.university.models.*;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddTeachingAssistantController implements Initializable {
    public RadioButton female;
    public TextField nameField;
    public TextField addressField;
    public TextField userNameField;
    public TextField passwordField;
    public TextField courseField;
    public RadioButton male;


    public void onBack() throws IOException {
        Navigation.navigateTo(Navigation.SYSTEM_MANGER_FXML);
    }

    public void onAddTeacherAssistant() {
        String name = nameField.getText().trim();
        byte gender = (byte) ((male.isSelected())? 1: 2);
        String address = addressField.getText().trim();
        String username = userNameField.getText().trim();
        String password = passwordField.getText();
        String courseName = courseField.getText().trim();
        TeachingAssistant ta = null;
        if (name.equals("") || address.equals("") || username.equals("") || password.equals("")) {
            MyAlert.errorAlert(
                    "No enough information",
                    "Error",
                    "Fill all fields to continue");
            return;
        }
        if (courseName.equals("")) {
            ta = new TeachingAssistant(username, password, name, gender, "phone", address);
            clear();
        }else{
            Course selected = null;
            for (Course course: Main.courses){
                if (course.getSubject().equals(courseName)){
                    selected = course;
                    break;
                }
            }
            if (selected == null)
                MyAlert.errorAlert(
                        "Course not found",
                        "Error",
                        String.format("There is no course named %s", courseName));
            else {
                ta = new TeachingAssistant(username, password, name, gender, "phone", address, selected);
                clear();
            }
        }
        Main.TAs.add(ta);
    }

    public void onRadioButtonToggle(ActionEvent actionEvent) {
        ToggleRadioButton.toggle(actionEvent, male, female);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        AutoComplete.setAutoComplete(courseField, Main.courses);
    }

    private void clear(){
        nameField.clear();
        addressField.clear();
        userNameField.clear();
        passwordField.clear();
        courseField.clear();
    }
}
