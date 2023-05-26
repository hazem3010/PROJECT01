package com.lab.university.controllers;

import com.lab.university.Main;
import com.lab.university.models.AutoComplete;
import com.lab.university.models.Navigation;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UpdateTeacherAssistantController implements Initializable {

    public AnchorPane rootPane;
    public TextField searchBar;
    public TextField name;
    public TextField phoneNumber1;
    public TextField address;
    public TextField userName;
    public TextField password;
    public TextField course;
    public RadioButton male;
    public RadioButton female;
    public TextField phoneNumber2;

    public void onSearch(){

    }
   public void onUpdate(){

   }
   public void onBack()throws IOException {
       Navigation.navigateTo(Navigation.SYSTEM_MANGER_FXML);
   }
   public void onRadioButtonToggle(){

   }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        AutoComplete.setAutoComplete(searchBar, Main.TAs);
    }
}
