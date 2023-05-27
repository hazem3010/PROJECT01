package com.lab.university.controllers;

import com.lab.university.Main;
import com.lab.university.models.*;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AddTeachingAssistantController implements Initializable {
    public RadioButton female;
    public TextField nameField;
    public TextField addressField;
    public TextField userNameField;
    public TextField passwordField;
    public TextField courseField;
    public RadioButton male;
    private static ArrayList<String> phoneNumbers = new ArrayList<>();
    private static String name;
    private static byte gender;
    private static String address;
    private static String username;
    private static String password;
    private static String courseName;



    public void onBack() throws IOException {
        Navigation.navigateTo(Navigation.SYSTEM_MANGER_FXML);
    }

    public void onAddTeacherAssistant() {
        getFields();
        TeachingAssistant ta = null;
        if (name.equals("") || address.equals("") || username.equals("") || password.equals("")) {
            MyAlert.errorAlert(
                    "No enough information",
                    "Error",
                    "Fill all fields to continue");
            return;
        }
        if (courseName.equals("")) {
            ta = new TeachingAssistant(username, password, name, gender, phoneNumbers, address);
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
                        String.format("There is no courseField named %s", courseName));
            else {
                ta = new TeachingAssistant(username, password, name, gender, phoneNumbers, address, selected);
                clear();
            }
        }
        Main.TAs.add(ta);
        phoneNumbers = new ArrayList<>();

    }

    private void getFields() {
        name = (nameField.getText() != null)? nameField.getText().trim(): "";
        gender = (byte) ((male.isSelected()) ? 1 : 2);
        address = (addressField.getText() != null)? addressField.getText().trim(): "";
        username = (userNameField.getText() != null)? userNameField.getText().trim(): "";
        password = (passwordField.getText() != null)? passwordField.getText(): "";
        courseName = (courseField.getText() != null)? courseField.getText().trim(): "";
    }
    private void setFields() {
        nameField.setText(name);
        switch (gender) {
            case 1 -> {
                male.setSelected(true);
                female.setSelected(false);
            }
            case 2 -> {
                male.setSelected(false);
                female.setSelected(true);
            }
        }
        addressField.setText(address);
        userNameField.setText(username);
        passwordField.setText(password);
        courseField.setText(courseName);
    }

    public void onRadioButtonToggle(ActionEvent actionEvent) {
        ToggleRadioButton.toggle(actionEvent, male, female);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setFields();
        AutoComplete.setAutoComplete(courseField, Main.courses);
    }

    private void clear(){
        nameField.clear();
        addressField.clear();
        userNameField.clear();
        passwordField.clear();
        courseField.clear();
        name = null;
        gender = 1;
        address = null;
        username = null;
        password = null;
        courseName = null;

    }

    public void toPhoneNumbers(ActionEvent actionEvent) throws IOException {
        getFields();
        PhoneNumbersController.phoneNumbers = phoneNumbers;
        PhoneNumbersController.backPath = Navigation.ADD_TEACHING_ASSISTANT;
        Navigation.navigateTo(Navigation.PHONE_NUMBERS_FXML);
    }
}
