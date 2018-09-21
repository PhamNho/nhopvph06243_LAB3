package com.nho_pc.nhopvph06243_lab3.model;

public class MyContact {
    public String name;
    public String phone;

    public MyContact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public MyContact() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
