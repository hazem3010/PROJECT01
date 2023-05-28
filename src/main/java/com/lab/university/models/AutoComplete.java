package com.lab.university.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Bounds;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.stage.Popup;

import java.util.ArrayList;

public class AutoComplete {

    public static <T> void setAutoComplete(TextField textField, ArrayList<T> arrayList){
        Popup popup = new Popup();
        ListView<String> listView = new ListView<>();
        ObservableList<String> observableList = FXCollections.observableArrayList();
        textField.setOnKeyTyped(keyEvent -> {
            String enteredText = (textField.getText() != null)? textField.getText().trim().toLowerCase(): "";
            if (enteredText.isEmpty()) popup.hide();
            else {
                observableList.clear();
                try{
                    if (arrayList.get(0) instanceof AutoCompletable){
                        for (T t : arrayList)
                            if (((AutoCompletable) t).toAutoComplete().toLowerCase().contains(enteredText))
                                observableList.add(((AutoCompletable) t).toAutoComplete());

                    }else if (arrayList.get(0) instanceof String){
                        for (T t : arrayList)
                            if (((String) t).toLowerCase().contains(enteredText))
                                observableList.add((String) t);
                    }else throw new IllegalArgumentException(
                            "Array list content must be of type String or implements AutoCompletable");
                } catch (IndexOutOfBoundsException e){
                    return;
                }

                if (observableList.size() <= 1 &&
                        (observableList.size() == 1 && observableList.get(0).equals(textField.getText()))) {
                    popup.hide();
                } else {
                    listView.setItems(observableList);
                    listView.getSelectionModel().clearSelection();
                    double listViewHeight = observableList.size() * 24 + 2;
                    listView.setPrefHeight(listViewHeight);
                    popup.getContent().clear();
                    popup.getContent().add(listView);
                    Bounds bounds = textField.localToScreen(textField.getBoundsInLocal());
                    popup.show(textField, bounds.getMinX(), bounds.getMaxY());
                }
            }
        });

        listView.setOnMouseClicked(e -> {
            textField.setText(listView.getSelectionModel().getSelectedItem());
            popup.hide();
        });

        listView.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                textField.setText(listView.getSelectionModel().getSelectedItem());
                popup.hide();
            }
        });
    }

}
