module com.lab.university {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;


    opens com.lab.university to javafx.fxml;
    exports com.lab.university;
    exports com.lab.university.controllers;
    opens com.lab.university.controllers to javafx.fxml;
    exports com.lab.university.models;
    opens com.lab.university.models to javafx.fxml;
}