package com.lab.university.controllers;

import com.lab.university.models.Navigation;

import java.io.IOException;

public class RemoveTeacherController {

    public void onRemove(){

    }
    public void onBack()throws IOException {
        Navigation.navigateTo(Navigation.SYSTEM_MANGER_FXML);
    }
}
