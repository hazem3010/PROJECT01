package com.lab.university.models;

import javafx.event.ActionEvent;
import javafx.scene.control.RadioButton;

public class ToggleRadioButton {
    public static void toggle(ActionEvent actionEvent, RadioButton... radioButtons) {
        for(RadioButton radioButton: radioButtons) radioButton.setSelected(actionEvent.getSource() == radioButton);
    }
}
