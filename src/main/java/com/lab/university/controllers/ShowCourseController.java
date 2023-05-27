package com.lab.university.controllers;

import com.lab.university.Main;
import com.lab.university.models.Course;
import com.lab.university.models.Navigation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ShowCourseController implements Initializable {

    public SplitPane root;
    public TableView<Course> table;
    public TableColumn<Course, String> NameCourse;

    public void onBack() throws IOException {
        Navigation.navigateTo(Navigation.SYSTEM_MANGER_FXML);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        NameCourse.setCellValueFactory(new PropertyValueFactory<>("subject"));
        List<Course> data = Main.courses;
        ObservableList<Course> observableList = FXCollections.observableArrayList(data);
        table.setItems(observableList);
    }
}