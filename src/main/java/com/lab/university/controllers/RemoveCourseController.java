package com.lab.university.controllers;

import com.lab.university.models.Navigation;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class RemoveCourseController {

    @FXML
    private AnchorPane rootPane;
    @FXML
    private TextField textField;


    public void onBack() throws IOException {
        Navigation.navigateTo(Navigation.SYSTEM_MANGER_FXML);
    }
    public void onRemove(){

    }

}
