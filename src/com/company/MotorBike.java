package com.company;

import java.util.Date;

public class MotorBike extends Vehicle {
    //instance variables
    private int engineSize;

    //constructor
    public MotorBike(String colour,String brand, int vehicleId,  int engineSize, DateTme time) {
        super(colour,brand, vehicleId,time);
        this.engineSize = engineSize;

    }


    //implement methods
    @Override
    public boolean park() {
        /////check whether car park full
        if (numOfSlot > 20) {
            System.out.println("slots are full, please try in sometime");
            return this.whetherParked = false;
        }
        System.out.println("please park your car in  slot " + numOfSlot);
        numOfSlot++;  //increase number of slot by one
        numOfVehicle++;   //increase number of vehicle by one
        WesministerCarParkManager.freeslots--;       //decrease free slots by one
        return this.whetherParked = true;
    }

    ////unpark  motorbike
    @Override
    public void unpark() {
        System.out.println("Thank you , come again");
        numOfVehicle--;   //decrease number of vehicle by one
        WesministerCarParkManager.numOfMotorBike--;       //decrease number of motorbike by one
        numOfSlot--;           //decrease number of slot by one
        WesministerCarParkManager.freeslots++;  //increase free slots by one
        this.whetherParked = false;
    }

    public void Display(){
        System.out.println("Vehicle ID : "+this.vehicleId+" , Brand : "+this.brand+" , engine size : "+this.engineSize + ", colour of vehicle :"+this.colour+ "\n"
                +", Date entried : "+this.datetime.getDate());
    }
}
