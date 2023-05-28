package com.lab.university.controllers;

import com.lab.university.models.Navigation;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.KeyEvent;

import java.io.IOException;

public class AttendanceStudentController {
    public Label lectureNameLabel;
    public TableView studentAttendance;
    public TableColumn id;
    public TableColumn name;
    public TableColumn phoneNumber;
    public ComboBox search;

    public void onKeyReleased(KeyEvent keyEvent) {
    }

    public void onBack(ActionEvent actionEvent) throws IOException {
        Navigation.navigateTo(Navigation.TEACHING_ASSISTANT_FXML);
    }

    public void onStudentAttendance(ActionEvent actionEvent) {
    }
}
