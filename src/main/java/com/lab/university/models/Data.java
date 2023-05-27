package com.lab.university.models;

import com.lab.university.Main;

import java.io.*;
import java.util.ArrayList;

public class Data {
//    Comment
    final static String DATA_DIRECTORY = "src/main/resources/com/lab/university/data/";
    public static <T> ArrayList<T> load(String fileName) throws ClassNotFoundException {
        try {
            return (ArrayList<T>) new ObjectInputStream(new FileInputStream(DATA_DIRECTORY+fileName)).readObject();
        }catch (IOException e) {
            return new ArrayList<>();
        }
    }

    public static Manager loadManager(){
        try {
            return (Manager) new ObjectInputStream(new FileInputStream(DATA_DIRECTORY+"manager.bin")).readObject();
        } catch (Exception e) {
            return null;
        }
    }

    public static void save() throws IOException {
        new ObjectOutputStream(new FileOutputStream(DATA_DIRECTORY+"manager.bin")).writeObject(Main.manager);
        new ObjectOutputStream(new FileOutputStream(DATA_DIRECTORY+"courses.bin")).writeObject(Main.courses);
        new ObjectOutputStream(new FileOutputStream(DATA_DIRECTORY+"teachingAssistants.bin")).writeObject(Main.TAs);
    }

}
