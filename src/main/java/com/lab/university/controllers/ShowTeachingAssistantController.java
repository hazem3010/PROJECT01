package com.lab.university.controllers;

import com.lab.university.Main;
import com.lab.university.models.Navigation;
import com.lab.university.models.TeachingAssistant;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ShowTeachingAssistantController implements Initializable {
    @FXML
    public TableView<TeachingAssistant> table;
    @FXML
    public SplitPane root;
    @FXML
    public TableColumn<TeachingAssistant, String> TAName;
    @FXML
    public TableColumn<TeachingAssistant, String> courseName;

    TeachingAssistant teachingAssistant = new TeachingAssistant();

    @Override
    public void initialize(URL url, ResourceBundle rb){
        TAName.setCellValueFactory(new PropertyValueFactory<>("name"));
        courseName.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getCourse().getSubject()));
        List<TeachingAssistant> data = Main.TAs;
        ObservableList<TeachingAssistant> observableList = FXCollections.observableArrayList(data);
        table.setItems(observableList);
    }
    public void onBack() throws IOException {
        Navigation.navigateTo(Navigation.SYSTEM_MANGER_FXML);
    }
}
