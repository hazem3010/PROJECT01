package com.lab.university;

import com.lab.university.models.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;


public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Scene home;
        try {
            ArrayList<User> users = Load.load("users.bin");
            home = new Scene(new FXMLLoader(Main.class.getResource("views/Login.fxml")).load());
        }catch (IOException e){
            home = new Scene(new FXMLLoader(Main.class.getResource("views/FirstUse.fxml")).load());
        }
        stage.setScene(home);
        stage.show();
    }
}
