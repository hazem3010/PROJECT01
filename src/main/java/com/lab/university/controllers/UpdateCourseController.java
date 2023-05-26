package com.lab.university.controllers;

import com.lab.university.Main;
import com.lab.university.models.Course;
import com.lab.university.models.Navigation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class UpdateCourseController {
   @FXML
   private AnchorPane rootPane;
   @FXML
    private TextField subject;
   @FXML
    private TextField bookName;
   @FXML
    private TextField place;
   @FXML
    private TextField instructor;

   public void Back() throws IOException {
       Navigation.navigateTo(Navigation.SYSTEM_MANGER_FXML);
   }
   public void Update(){

   }

    public void search(ActionEvent actionEvent) {
       Course selected;
       for (Course course: Main.courses){

       }
    }
}
