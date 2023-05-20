package com.lab.university;

import java.io.*;
import java.util.ArrayList;

public class Load{
    final static String DATA_DIRECTORY = "src/main/resources/com/lab/university/data/";
    public static <T> ArrayList<T> load(String fileName) throws IOException {
        ArrayList<T> objectList = new ArrayList<>();

        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(DATA_DIRECTORY+fileName))) {
            int count = inputStream.readInt();
            for (int i = 1; i < count + 1; i++){
                objectList.add((T) inputStream.readObject());
            }
        }catch (IOException e){
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(DATA_DIRECTORY+fileName));
            output.writeInt(0);
            output.close();
            throw e;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return objectList;
    }

}
