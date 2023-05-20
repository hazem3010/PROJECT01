package com.lab.university.controllers;

import com.lab.university.models.User;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class FirstUseController {
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField usernameField;

    public void register() {
        User admin = new User();
    }
}
