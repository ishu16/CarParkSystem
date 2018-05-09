package com.company;

import java.util.Date;

public class Car extends Vehicle {

    //instance variables
    private int numOfDoors;


    //constructor
    public Car(String colour, String brand, int vehicleId, int numOfDoors, DateTme time) {
        super(colour, brand, vehicleId, time);
        this.numOfDoors = numOfDoors;
    }

    //implement methods
    @Override
    public boolean park() {
    /////check whether car park full
        if (WesministerCarParkManager.freeslots > 20) {
            return this.whetherParked = false;
        }
        System.out.println("please park your car in  slot " + numOfSlot);
        numOfSlot++;
        numOfVehicle++;
        WesministerCarParkManager.freeslots--;
        return this.whetherParked = true;
    }

    //umpark car
    @Override
    public void unpark() {
        System.out.println("Thank you , come again");
        numOfVehicle--;  //decrease number of vehicle by one
        WesministerCarParkManager.numOfCar --; //decrease number of car by one
        numOfSlot--;  //decrease number of slot by one
        WesministerCarParkManager.freeslots++;  //increase free slots by one
        this.whetherParked = false;
    }

    //display method
    public void Display() {
        System.out.println("Vehicle ID : " + this.vehicleId + " , Brand : " + this.brand + " , Number of doors : " + this.numOfDoors + ", colour of vehicle :" +this.colour+ "\n "
        +", Date entried : "+this.datetime.getDate());
    }
}
