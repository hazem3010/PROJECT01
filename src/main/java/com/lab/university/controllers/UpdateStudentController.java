package com.lab.university.controllers;

import com.lab.university.models.*;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
import java.util.ResourceBundle;

public class UpdateStudentController implements Initializable {
    public RadioButton male;
    public RadioButton female;
    public TextField searchBar;
    public TextField nameField;
    public TextField addressField;
    public TextField idField;
    private static String name;
    private static byte gender;
    private static ArrayList<String> phoneNumbers;
    private static String id;
    private static String address;
    private static Student selectedStudent;
    private static Map<Student, Integer> students;


    public void onSearch(ActionEvent actionEvent) {
        selectedStudent = null;
        for (Student student : students.keySet())
            if (student.getName().equalsIgnoreCase(searchBar.getText().trim())) {
                selectedStudent = student;
                break;
            }
        if (selectedStudent != null) {
            name = selectedStudent.getName();
            gender = selectedStudent.getGender();
            phoneNumbers = selectedStudent.getPhoneNumbers();
            id = selectedStudent.getID();
            address = selectedStudent.getAddress();
            setFields();
        }
    }

    public void onBack(ActionEvent actionEvent) throws IOException {
        clear();
        Navigation.navigateTo(Navigation.TEACHING_ASSISTANT_FXML);
    }

    public void onUpdate(ActionEvent actionEvent) {
        if (selectedStudent == null){
            MyAlert.errorAlert("No student selected", "Error", "Select a student to update");
        }else {
            getFields();
            selectedStudent.setName(name);
            selectedStudent.setGender(gender);
            selectedStudent.setPhoneNumbers(phoneNumbers);
            selectedStudent.setID(id);
            selectedStudent.setAddress(address);
            clear();
        }
    }

    private void clear() {
        searchBar.clear();
        nameField.clear();
        male.setSelected(true);
        female.setSelected(false);
        phoneNumbers = null;
        idField.clear();
        addressField.clear();
        getFields();
    }

    public void onRadioButtonToggle(ActionEvent actionEvent) {
        ToggleRadioButton.toggle(actionEvent, male, female);
    }

    public void toCourses(ActionEvent actionEvent) throws IOException {
        getFields();
        CoursesController.backPath = Navigation.UPDATE_STUDENT_FXML;
        Navigation.navigateTo(Navigation.COURSES_FXML);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setFields();
        students = TeachingAssistantController.signedInTA.getCourse().getStudents();
        AutoComplete.setAutoComplete(searchBar, new ArrayList<>(students.keySet()));
    }

    private void setFields() {
        nameField.setText(name);
        male.setSelected(gender == 1);
        female.setSelected(gender == 2);
        idField.setText(id);
        addressField.setText(address);
    }

    public void toPhoneNumbers(ActionEvent actionEvent) throws IOException {
        getFields();
        PhoneNumbersController.backPath = Navigation.UPDATE_STUDENT_FXML;
        PhoneNumbersController.phoneNumbers = phoneNumbers;
        Navigation.navigateTo(Navigation.PHONE_NUMBERS_FXML);
    }

    private void getFields() {
        name = (nameField.getText() != null)? nameField.getText().trim(): "";
        gender = (byte) ((male.isSelected())? 1: 2);
        id = (idField.getText() != null)? idField.getText().trim(): "";
        address = (addressField.getText() != null)? addressField.getText().trim(): "";
    }
}
