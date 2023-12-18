package com.dealership.demo.models;

public class Main {
    public static void main(String[] args) {
        Dealership dealership = DealershipFileManager.getDealership();

        UserInterface userInterface = new UserInterface(dealership);
        userInterface.display();

    }
    }
