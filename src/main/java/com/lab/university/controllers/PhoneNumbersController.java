package com.lab.university.controllers;

import com.lab.university.models.AutoComplete;
import com.lab.university.models.Format;
import com.lab.university.models.MyAlert;
import com.lab.university.models.Navigation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PhoneNumbersController implements Initializable {
    public static String backPath;
    public AnchorPane rootPane;
    public ListView<String> phoneNumberListView;
    public TextField phoneNumberField;
    public static ArrayList<String> phoneNumbers;

    public void addPhoneNumber(ActionEvent actionEvent) {
        if (!phoneNumberField.getText().isEmpty()) {
            phoneNumbers.add(phoneNumberField.getText());
            showViewList();
        } else MyAlert.errorAlert("Empty field", "Error", "Enter a phone number to add");
    }

    public void removePhoneNumber(ActionEvent actionEvent) {
        if (!phoneNumberField.getText().isEmpty()) {
            phoneNumbers.remove(phoneNumberField.getText());
            showViewList();
        } else MyAlert.errorAlert("Empty field", "Error", "Enter a phone number to remove");
    }

    public void goBack(ActionEvent actionEvent) throws IOException {
        Navigation.navigateTo(backPath);
        phoneNumbers = null;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Format.onlyDigits(phoneNumberField);
        showViewList();
    }
    private void showViewList(){
        ObservableList<String> data = FXCollections.observableArrayList(phoneNumbers);
        AutoComplete.setAutoComplete(phoneNumberField, phoneNumbers);
        phoneNumberListView.setItems(data);
    }
}
