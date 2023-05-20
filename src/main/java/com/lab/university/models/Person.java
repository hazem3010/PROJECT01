package com.lab.university.models;

public class Person {

    private String name;
    private byte gender;
    private String[] phone;
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

    public String[] getPhone() {
        return phone;
    }

    public void setPhone(String[] phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Person(String name, byte gender, String[] phone, String address) {
        this.name = name;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
    }
    public Person(){

    }
}
