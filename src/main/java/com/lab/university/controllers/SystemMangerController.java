package com.lab.university.controllers;

import com.lab.university.models.Navigation;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class SystemMangerController {
    @FXML
    private AnchorPane rootPane;

   public void addCourse() throws IOException {
       Navigation.navigateTo(Navigation.ADD_COURSE_FXML);
}
   public  void removeCourse() throws IOException {
       Navigation.navigateTo(Navigation.REMOVE_FXML);
   }
   public void updateCourse() throws IOException {
      Navigation.navigateTo(Navigation.UPDATE_COURSE_FXML);
   }
   public void back() throws IOException {
       Navigation.navigateTo(Navigation.LOGIN_FXML);
   }
   public void showCourses() throws IOException {
       Navigation.navigateTo(Navigation.SHOW_COURSE_FXML);
   }
   public void updateTeachingAssistant(){

   }
   public void removeTeachingAssistant(){

   }
   public void addTeachingAssistant() throws IOException {
       Navigation.navigateTo(Navigation.ADD_TEACHING_ASSISTANT);
   }
}
