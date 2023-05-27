package com.lab.university.controllers;

import com.lab.university.models.*;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AddStudentController implements Initializable {
    public RadioButton female;
    public TextField nameField;
    public TextField addressField;
    public RadioButton male;
    private static String name;
    private static byte gender;
    private static ArrayList<String> phoneNumbers = new ArrayList<>();
    private static String id;
    private static String address;
    private static ArrayList<Course> courses = new ArrayList<>();
    public TextField IDField;

    public void addStudent(ActionEvent actionEvent) {
        getFields();
        if (name.isEmpty() || id.isEmpty() || address.isEmpty())
            MyAlert.errorAlert("No enough data", "Error", "Fill all fields to continue");
        else {
            Student student = new Student(name, gender, phoneNumbers, address, id, courses);
            clear();
        }
    }

    private void clear() {
        nameField.clear();
        male.setSelected(true);
        female.setSelected(false);
        phoneNumbers = new ArrayList<>();
        IDField.clear();
        addressField.clear();
        courses = new ArrayList<>();
        getFields();
    }

    private void getFields() {
        name = (nameField.getText() != null)? nameField.getText().trim(): "";
        gender = (byte) ((male.isSelected())? 1: 2);
        id = (IDField.getText() != null)? IDField.getText().trim(): "";
        address = (addressField.getText() != null)? addressField.getText().trim(): "";
    }

    public void onBack(ActionEvent actionEvent) throws IOException {
        clear();
        Navigation.navigateTo(Navigation.TEACHING_ASSISTANT_FXML);
    }

    public void onRadioButtonToggle(ActionEvent actionEvent) {
        ToggleRadioButton.toggle(actionEvent, male, female);
    }

    public void toPhoneNumbers(ActionEvent actionEvent) throws IOException {
        getFields();
        PhoneNumbersController.backPath = Navigation.ADD_STUDENT_FXML;
        PhoneNumbersController.phoneNumbers = phoneNumbers;
        Navigation.navigateTo(Navigation.PHONE_NUMBERS_FXML);
    }

    public void toCourses(ActionEvent actionEvent) throws IOException {
        getFields();
        CoursesController.backPath = Navigation.ADD_STUDENT_FXML;
        CoursesController.courses = courses;
        Navigation.navigateTo(Navigation.COURSES_FXML);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setFields();
    }

    private void setFields() {
        nameField.setText(name);
        male.setSelected(gender == 1);
        female.setSelected(gender == 2);
        IDField.setText(id);
        addressField.setText(address);
    }
}
