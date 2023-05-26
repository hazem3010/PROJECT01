package com.lab.university.controllers;

import com.lab.university.models.Navigation;
import com.lab.university.models.TeachingAssistant;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ShowTeacherController implements Initializable {
    @FXML
    public TableView<TeachingAssistant> table;
    @FXML
    public SplitPane root;
    @FXML
    public TableColumn NameTeacher;
    @FXML
    public TableColumn NameCourse;

    TeachingAssistant teachingAssistant = new TeachingAssistant();

    @Override
    public void initialize(URL url, ResourceBundle rb){
        NameTeacher.setCellValueFactory(new PropertyValueFactory<>("name"));
        NameCourse.setCellValueFactory(new PropertyValueFactory<>("course"));

    }
    public void onBack() throws IOException {
        Navigation.navigateTo(Navigation.SYSTEM_MANGER_FXML);
    }
}
