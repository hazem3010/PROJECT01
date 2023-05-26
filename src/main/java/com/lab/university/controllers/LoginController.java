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
        for(User user: Main.users){
            if (user.getUserName().equals(username) && user.getPassword().equals(passwordField.getText())){
                if (user instanceof Manager) Navigation.navigateTo(Navigation.SYSTEM_MANGER_FXML);
                else Navigation.navigateTo(Navigation.TEACHING_ASSISTANT_FXML);
                return;
            }
        }
        MyAlert.errorAlert("Error", "Credentials Error", "Wrong username or passwordField");
    }
}
