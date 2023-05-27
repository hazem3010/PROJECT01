package com.lab.university.models;

import java.io.Serializable;
import java.util.ArrayList;

public class User extends Person implements Serializable {
     private String userName;
     private String password;

     public User(String userName, String password, String name, byte gender, ArrayList<String> phone, String address) {
          super(name, gender, phone, address);
          this.userName = userName;
          this.password = password;
     }
     public User(){}

     public String getUserName() {
          return userName;
     }

     public void setUserName(String userName) {
          this.userName = userName;
     }

     public String getPassword() {
          return password;
     }

     public void setPassword(String password) {
          this.password = password;
     }
}
