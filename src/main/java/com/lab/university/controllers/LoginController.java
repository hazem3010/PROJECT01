package com.lab.university.controllers;

import com.lab.university.Main;
import com.lab.university.models.*;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginController {
    public TextField usernameField;
    public TextField passwordField;

    public void login() throws IOException {
        String username = usernameField.getText().trim();
        String password = passwordField.getText();
        if (Main.manager.getUserName().equals(username) && Main.manager.getPassword().equals(password)){
            Navigation.navigateTo(Navigation.SYSTEM_MANGER_FXML);
            return;
        }
        for(TeachingAssistant ta: Main.TAs){
            if (ta.getUserName().equals(username) && ta.getPassword().equals(passwordField.getText())){
                TeachingAssistantController.signedInTA = ta;
                Navigation.navigateTo(Navigation.TEACHING_ASSISTANT_FXML);
                return;
            }
        }
        MyAlert.errorAlert("Error", "Credentials Error", "Wrong username or password");
    }
}
