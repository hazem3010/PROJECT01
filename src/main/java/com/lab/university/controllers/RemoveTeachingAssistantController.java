package com.lab.university.controllers;

import com.lab.university.Main;
import com.lab.university.models.*;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RemoveTeachingAssistantController implements Initializable {

    public AnchorPane rootPane;
    public javafx.scene.control.TextField textField;

    public void onRemove(){
        for (TeachingAssistant ta: Main.TAs) {
            if (ta.getName().equalsIgnoreCase(textField.getText())) {
                Main.TAs.remove(ta);
                MyAlert.informationAlert("TA deleted!", "Success", String.format("TA %s deleted successfully", ta.getName()));
                return;
            }
        }
        MyAlert.errorAlert("TA not found", "Error", String.format("There is no TA named %S", textField.getText()));
    }
    public void onBack()throws IOException {
        Navigation.navigateTo(Navigation.SYSTEM_MANGER_FXML);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        AutoComplete.setAutoComplete(textField, Main.TAs);
    }
}
