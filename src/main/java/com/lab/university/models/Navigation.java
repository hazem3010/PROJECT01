package com.lab.university.models;

import com.lab.university.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Navigation {
    private static Stage stage;
    public static final String SYSTEM_MANGER_FXML= "views/SystemManger.fxml";
    public static final String LOGIN_FXML = "views/Login.fxml";
    public static final String ADD_COURSE_FXML = "views/AddCourse.fxml";
    public static final String FIRST_USE_FXML = "views/FirstUse.fxml";
    public static final String REMOVE_COURSE_FXML = "views/RemoveCourse.fxml";
    public static final String UPDATE_COURSE_FXML = "views/UpdateCourse.fxml";
    public static final String SHOW_COURSE_FXML = "views/ShowCourse.fxml";
    public static final String ADD_TEACHING_ASSISTANT = "views/AddTeachingAssistant.fxml";
    public static final String TEACHING_ASSISTANT_FXML = "views/TeachingAssistant.fxml";
    public static final String SHOW_TEACHER_FXML = "views/ShowTeacher.fxml";
    public static final String REMOVE_TEACHER_FXML = "views/RemoveTeacher.fxml";
    public static final String UPDATE_TEACHER_FXML = "views/updateTeacherAssistant.fxml";

    public static void setStage(Stage stage){
        Navigation.stage = stage;
    }

    public static void navigateTo(String path) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(path));
        Parent parent = fxmlLoader.load();
        stage.setScene(new Scene(parent));
    }
}
