package com.lab.university.models;

import com.lab.university.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Navigation {
    public static final String UPDATE_STUDENT_FXML = "views/UpdateStudent.fxml";
    public static final String COURSES_FXML = "views/Courses.fxml";
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
    public static final String REMOVE_TEACHER_FXML = "views/RemoveTeachingAssistant.fxml";
    public static final String UPDATE_TEACHER_FXML = "views/UpdateTeachingAssistant.fxml";
    public static final String PHONE_NUMBERS_FXML = "views/PhoneNumbers.fxml";
    public static final String ADD_STUDENT_FXML = "views/AddStudent.fxml";
    public static final String REMOVE_STUDENT_FXML = "views/RemoveStudent.fxml";
    public static final String ADD_LECTURE_FXML = "views/AddLecture.fxml";
    public static final String UPDATE_LECTURE_FXML = "views/UpdateLecture.fxml";
    public static final String REMOVE_LECTURE_FXML = "views/RemoveLecture.fxml";
    private static Stage stage;

    public static void setStage(Stage stage){
        Navigation.stage = stage;
    }

    public static void navigateTo(String path) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(path));
        Parent parent = fxmlLoader.load();
        stage.setScene(new Scene(parent));
    }
}
