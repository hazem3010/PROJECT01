package com.lab.university.controllers;

import com.lab.university.models.AutoComplete;
import com.lab.university.models.MyAlert;
import com.lab.university.models.Navigation;
import com.lab.university.models.Student;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
import java.util.ResourceBundle;

public class RemoveStudentController implements Initializable {
    public javafx.scene.control.TextField textField;
    private static Map<Student, Integer> students;

    public void onBack(ActionEvent actionEvent) throws IOException {
        Navigation.navigateTo(Navigation.TEACHING_ASSISTANT_FXML);
    }

    public void onRemove(ActionEvent actionEvent) {
        for (Student student: students.keySet()){
            if (student.getName().equalsIgnoreCase(textField.getText().trim())){
                students.remove(student);
                MyAlert.informationAlert(
                        "Removed",
                        "Success",
                        String.format("Student %s was removed successfully", student.getName()));
                return;
            }
        }
        MyAlert.errorAlert(
                "Student not found",
                "Error",
                String.format("There is no student named %s", textField.getText()));
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        students = TeachingAssistantController.signedInTA.getCourse().getStudents();
        AutoComplete.setAutoComplete(textField, new ArrayList<>(students.keySet()));
    }
}
