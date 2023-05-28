package com.lab.university.models;

import java.io.Serializable;
import java.util.ArrayList;

public class Person implements Serializable {

    private String name;
    private byte gender;
    private ArrayList<String> phoneNumbers = new ArrayList<>();
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getGender() {
        return gender;
    }

    public void setGender(byte gender) {
        this.gender = gender;
    }

    public ArrayList<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(ArrayList<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Person(String name, byte gender, ArrayList<String> phoneNumbers, String address) {
        this.name = name;
        this.gender = gender;
        this.phoneNumbers = phoneNumbers;
        this.address = address;
    }
    public Person(){

    }

    public String getPhoneNumber() {
        if (phoneNumbers.isEmpty()) {
            return "";
        }
        return phoneNumbers.get(0);
    }
}
