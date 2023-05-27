package com.lab.university.controllers;

import com.lab.university.Main;
import com.lab.university.models.AutoComplete;
import com.lab.university.models.Navigation;
import com.lab.university.models.TeachingAssistant;
import com.lab.university.models.ToggleRadioButton;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class UpdateTeachingAssistantController implements Initializable {

    public AnchorPane rootPane;
    public TextField searchBar;
    public TextField nameField;
    public TextField addressField;
    public TextField userNameField;
    public TextField passwordField;
    public TextField courseField;
    public RadioButton male;
    public RadioButton female;
    private static ArrayList<String> phoneNumbers = new ArrayList<>();
    private static TeachingAssistant selectedTA = new TeachingAssistant();
    private static String name;
    private static byte gender;
    private static String address;
    private static String username;
    private static String password;
    private static String courseName;

    public void onSearch(){
        for (TeachingAssistant ta: Main.TAs) if (ta.getName().equalsIgnoreCase(searchBar.getText().trim())){
            nameField.setText(ta.getName());
            male.setSelected(ta.getGender() == 1);
            female.setSelected(ta.getGender() == 2);
            phoneNumbers = ta.getPhoneNumbers();
            addressField.setText(ta.getAddress());
            userNameField.setText(ta.getUserName());
            passwordField.setText(ta.getPassword());
            courseField.setText(ta.getCourse().getSubject());
            selectedTA = ta;
            return;
        }
    }
    public void onUpdate(){
        getFields();
        selectedTA.setName(name);
        selectedTA.setGender(gender);
        selectedTA.setPhoneNumbers(phoneNumbers);
        selectedTA.setAddress(address);
        selectedTA.setUserName(username);
        selectedTA.setPassword(password);
        clear();
    }
    public void onBack()throws IOException {
       Navigation.navigateTo(Navigation.SYSTEM_MANGER_FXML);
       clear();
    }

    private void clear() {
        selectedTA = null;
        nameField.clear();
        male.setSelected(true);
        female.setSelected(false);
        phoneNumbers = new ArrayList<>();
        addressField.clear();
        userNameField.clear();
        courseField.clear();
        passwordField.clear();
        getFields();
    }

    public void onRadioButtonToggle(ActionEvent actionEvent){
        ToggleRadioButton.toggle(actionEvent, male, female);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setFields();
        AutoComplete.setAutoComplete(searchBar, Main.TAs);
        AutoComplete.setAutoComplete(courseField, Main.courses);
    }

    public void toPhoneNumbers(ActionEvent actionEvent) throws IOException {
        PhoneNumbersController.backPath = Navigation.UPDATE_TEACHER_FXML;
        PhoneNumbersController.phoneNumbers = phoneNumbers;
        getFields();
        Navigation.navigateTo(Navigation.PHONE_NUMBERS_FXML);
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
        male.setSelected(gender == 1);
        female.setSelected(gender == 2);
        addressField.setText(address);
        userNameField.setText(username);
        passwordField.setText(password);
        courseField.setText(courseName);
    }
}
