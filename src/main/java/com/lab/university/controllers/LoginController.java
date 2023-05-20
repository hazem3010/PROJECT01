package com.lab.university.controllers;

import com.lab.university.Load;
import com.lab.university.models.User;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.ArrayList;

public class LoginController {
    public TextField usernameField;
    public TextField passwordField;
    ArrayList<User> users;

    {
        try {
            users = Load.load("users.bin");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    
}
