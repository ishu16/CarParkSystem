package com.company;

import java.io.Serializable;
import java.util.Date;

public abstract class Vehicle {

    //Static variables
    public static int numOfVehicle = 0;
    public static int numOfSlot =0;

    //instance variables
    public int vehicleId;
    protected String colour;
    protected String brand;

    protected DateTme datetime;
    protected int price;
    protected long stayTime;

    public boolean whetherParked = false;

    //getters and setters

    public DateTme getDatetime() {
        return datetime;
    }


    //constructor
    public Vehicle(String colour,String brand, int vehicleId, DateTme time) {
        this.colour = colour;
        this.brand = brand;
        this.vehicleId = vehicleId;
        this.datetime = time;
         }


    //abstract methods
    public abstract boolean park();

    //abstract methods
    public abstract void unpark();

    public void Display(){

    }


}
