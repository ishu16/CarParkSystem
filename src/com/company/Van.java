package com.company;


import java.util.Date;


public class Van extends Vehicle {

    //instance variables
    private int cargoVolume;


    //constructor
    public Van(String colour, String brand, int vehicleId, int cargoVolume, DateTme time) {
        super(colour, brand, vehicleId, time);
        this.cargoVolume = cargoVolume;
    }

    //implement methods
    @Override
    public boolean park() {
        //vheck whether number of slots are over 18 cause vam need 2 slots
        if (numOfSlot > 18) {
            System.out.println("Your van can not be accomodated in this slot alone, please try in sometime");
            return this.whetherParked = false;
        }
        System.out.println("please park your van in  " + "  " + numOfSlot + "  " + "  slot");
        numOfSlot = numOfSlot + 2;   //increase number of slot by 2
        numOfVehicle++;//increase number of vehicle by one
        WesministerCarParkManager.freeslots = WesministerCarParkManager.freeslots -2;    //decrease free slots by 2
        return this.whetherParked = true;
    }

    @Override
    public void unpark() {
        System.out.println("Thank you , come again");
        numOfVehicle--;//decrease number of vehicle by one
        WesministerCarParkManager.numOfVan --; //decrease number of van by one
        numOfSlot = numOfSlot -2;    //decrease number of slot by 2
        WesministerCarParkManager.freeslots = WesministerCarParkManager.freeslots +2;   //increase free slots by 2
        this.whetherParked = false;

    }

    public void Display() {
        System.out.println("Vehicle ID : " + this.vehicleId + " , Brand : " + this.brand + " , cargo volume : " + this.cargoVolume + ", colour of vehicle :" + this.colour+"\n"
                +", Date entried : "+this.datetime.getDate());
    }
}
