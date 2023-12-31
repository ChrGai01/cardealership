package com.dealership.demo.models;

import java.util.ArrayList;

public class Dealership  {
    private int Id;
    private String name;
    private String address;
    private int phone;
    public ArrayList<Vehicle> inventory = new ArrayList<>();

    public Dealership(int id, String name, String address, int phone) {
        Id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;

    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
}
