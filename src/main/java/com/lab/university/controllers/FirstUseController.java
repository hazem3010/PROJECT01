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

    public void register() throws IOException {
        String username = usernameField.getText().trim();
        String password = passwordField.getText();
        String name = nameField.getText();
        byte gender;
        String address = addressField.getText();
        String phone = phoneFiled.getText();
        if (Male.isSelected()) gender = 1;
        else if (Female.isSelected()) gender = 2;
        else return;
        if (username.equals("") || password.equals("") || name.equals("") || address.equals("") || phone.equals(""))
            MyAlert.errorAlert("No enough information", "Error", "You must fill all fields to continue");
        User admin = new Manager(username, password, name, gender, phone ,address);
        Main.users.add(admin);
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
