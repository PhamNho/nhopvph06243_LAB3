package com.nho_pc.nhopvph06243_lab3.model;

public class MyContact {
    public String name;
    public String ID;
    public String Phone;

    public MyContact(String name, String ID, String phone) {
        this.name = name;
        this.ID = ID;
        Phone = phone;
    }

    public MyContact() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }
}
