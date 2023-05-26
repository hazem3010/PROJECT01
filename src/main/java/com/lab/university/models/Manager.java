package com.lab.university.models;

import java.io.Serializable;

public class Manager extends  User implements Serializable {
    public Manager() {
        super();
    }

    public Manager(String userName, String password, String name, byte gender, String phone, String address) {
        super(userName, password, name, gender, phone, address);
    }
}
