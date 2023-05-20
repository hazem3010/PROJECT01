package com.lab.university.models;

public class User extends Person {
     private String userName;
     private String password;

     public User(String userName, String password, String name, byte gender, String[] phone, String address) {
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
