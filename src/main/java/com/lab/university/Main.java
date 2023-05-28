package com.lab.university;

import com.lab.university.models.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;


public class Main extends Application {
    public static Manager manager;
    public static ArrayList<Course> courses;
    public static ArrayList<TeachingAssistant> TAs;
    public static ArrayList<Student> students;


    @Override
    public void start(Stage stage) throws Exception {
        Navigation.setStage(stage);
        Scene home;
        stage.setTitle("University");
        manager = Data.loadManager();
        courses = Data.load("courses.bin");
        TAs = Data.load("teachingAssistants.bin");
        students = Data.load("students.bin");
        String fxmlUrl = (manager != null)?"views/Login.fxml":"views/FirstUse.fxml";
        home = new Scene(new FXMLLoader(Main.class.getResource(fxmlUrl)).load());
        stage.setScene(home);
        stage.show();
        stage.setOnCloseRequest(event -> {
            try {
                Data.save();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

}
