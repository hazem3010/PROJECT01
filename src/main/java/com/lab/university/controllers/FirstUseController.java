package com.lab.university.controllers;

import com.lab.university.Main;
import com.lab.university.models.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class FirstUseController implements Initializable {
    public TextField nameField;
    @FXML
    public RadioButton Female;
    @FXML
    public RadioButton Male;
    @FXML
    public PasswordField passwordField;
    @FXML
    public TextField usernameField;
    public TextField addressField;
    public TextField phoneFiled;
    ArrayList<String> phoneNumber;

    public void register() throws IOException {
        String username = usernameField.getText().trim();
        String password = passwordField.getText();
        String name = nameField.getText();
        byte gender;
        String address = addressField.getText();
        phoneNumber = new ArrayList<>();
        phoneNumber.add(phoneFiled.getText());
        if (Male.isSelected()) gender = 1;
        else if (Female.isSelected()) gender = 2;
        else return;
        if (username.equals("") || password.equals("") || name.equals("") || address.equals("") || phoneFiled.getText().equals(""))
            MyAlert.errorAlert("No enough information", "Error", "You must fill all fields to continue");
        Main.manager = new Manager(username, password, name, gender, phoneNumber ,address);
        Navigation.navigateTo(Navigation.SYSTEM_MANGER_FXML);
    }

    public void toggleGender(ActionEvent actionEvent) {
        ToggleRadioButton.toggle(actionEvent, Male, Female);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Format.onlyDigits(phoneFiled);
    }
}
