
package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class WesministerCarParkManager implements ParkingManager {

    //scanner
    public static Scanner sc = new Scanner(System.in);

    //static Vehicle[] vehiclesAvailable = new Vehicle[20];

    //Arrays to store the objects
    private static ArrayList<Vehicle> vehicleArrayList = new ArrayList<>();

    public static int freeslots = 20;

    //payment variables
    private static double hoursParked;
    public static double payment = 0;

    //Global variables to count the cars vans and bikes
    public static int numOfCar = 0;
    public static int numOfVan = 0;
    public static int numOfMotorBike = 0;

// Menu bar
    public static void menuOptions() {
        System.out.println("                                                                              ");
        System.out.println("\t \t\t\t ~~~~~~~~~~~~~~~~~~~~~ WELCOME TO CAR PARK ~~~~~~~~~~~~~~~~~~~~~~~~~ ");
        System.out.println("                                                                          ");
        System.out.println("\t \t\t\t ---------Please select what you want to do in the Garage----------- ");
        System.out.println("\t \t\t\t|                                                                   |");
        System.out.println("\t \t\t\t ---------Enter 1 to Add vehicles to the Garage--------------------- ");
        System.out.println("\t \t\t\t|                                                                   |");
        System.out.println("\t \t\t\t -------- Enter 2 Remove vehicles from the Garage------------------- ");
        System.out.println("\t \t\t\t|                                                                   |");
        System.out.println("\t \t\t\t ---------Enter 3 to show Vehicles in the Garage---------------------");
        System.out.println("\t \t\t\t|                                                                   |");
        System.out.println("\t \t\t\t ---------Enter 4 to show Statistics in the Garage------------------ ");
        System.out.println("\t \t\t\t|                                                                   |");
        System.out.println("\t \t\t\t ---------Enter 5 to show Details of specify day vehicles ---------- ");
        System.out.println("\t \t\t\t|                                                                   |");

    }

    public static void menu() {


        do {
            int input = sc.nextInt();//gets the input from the user

            switch (input) {

                case 1:
                    addVehicles();//addVehicle method is called
                    break;

                case 2:
                    removeVehicles();//removevehicle method is called
                    break;
                case 3:
                    showVehicles();
                    break;
                case 4:
                    statistics();//statistics method is called
                    break;
                case 5:
                    DetailsOfaSpecificDay();
                    break;

                default://executes if an invalid input is provided
                    System.out.println(" ");
                    System.out.println(" Invalid Input !");//displays
                    menu();//returns to the menu
            }
            menuOptions();
            System.out.println(" Please enter a number to proceed >>>> ");
        } while (sc.hasNext());
    }

    //from this method Getting user inputs about vehicle details
    private static void addVehicles() {
        System.out.println("please enter what kind of a vehicle do you want to add");
        System.out.println("1.Car");
        System.out.println("2.Van");
        System.out.println("3.Motorbike");
        int num = sc.nextInt(); //get the user selection

// to check  free slots
        if (freeslots > 0) {
            switch (num) {
                case 1:

                    System.out.print(" ");
                    System.out.print("\t\t---------- Add your car -----------");
                    System.out.print(" ");
                    System.out.println("\n\t\t\t  Enter ID : ");
                    int vehicleId = sc.nextInt();
                    System.out.println("\n\t\t\t Entry Date(Format-Year Month Day : ");
                    System.out.println("\n\t  Year  :");
                    int year = sc.nextInt();
                    System.out.println("\n\t  Month  :");
                    int month = sc.nextInt();
                    System.out.println("\n\t  Date  :");
                    int day = sc.nextInt();
                    System.out.println("\n\t\t\t  Entry Time(Format- Hour Minute) :");
                    System.out.println("\n\t  Hour  :");
                    int hour = sc.nextInt();
                    System.out.println("\n\t  Minute  :");
                    int minute = sc.nextInt();
                    System.out.print("\n\t\t\t    Enter the car brand : ");
                    String brandCar = sc.next();
                    System.out.print("\n\t\t\t    Enter the number of doors : ");
                    int numOfDoorsCar = sc.nextInt();
                    System.out.print("\n\t\t\t    Enter the color of the car: ");
                    String colourCar = sc.next();
                    System.out.println("                     ");
                    System.out.println("car added succesfully");

                    numOfCar++;  //increase number of car by one

                    DateTme entry = new DateTme(day,month,year,hour,minute); //datetime object
                    Vehicle d = new Car(colourCar, brandCar, vehicleId, numOfDoorsCar, entry);
                    if (d.park()){
                        vehicleArrayList.add(d);
                        System.out.println("The Car has been unparked is : "+(20 - Vehicle.numOfVehicle));
                    }else{
                        System.out.println("The car cannot be parked here.");
                    }
                    break;

                case 2:
                    // van occupied 2 slots , check free slots are over 2 slots
                    if (freeslots > 2) {

                        System.out.print(" ");
                        System.out.print("\t\t---------- Add your Van -----------");
                        System.out.print(" ");
                        System.out.println("\n\t\t\t  Enter ID : ");
                        vehicleId = sc.nextInt();
                        System.out.println("\n\t\t\t  Entry Date(Format-Year Month Day : ");
                        System.out.println("\n\t  Year  :");
                        year = sc.nextInt();
                        System.out.println("\n\t  Month  :");
                        month = sc.nextInt();
                        System.out.println("\n\t  Date  :");
                        day = sc.nextInt();
                        System.out.println("\n\t\t\t  Entry Time(Format- Hour Minute)");
                        System.out.println("\n\t  Hour  :");
                        hour = sc.nextInt();
                        System.out.println("\n\t  Minute  :");
                        minute = sc.nextInt();
                        System.out.print("\n\t\t\t    Enter the Van brand : ");
                        String brandVan = sc.next();
                        System.out.print("\t\t\t      Enter the number of cargoVolume : ");
                        int cargoVolume = sc.nextInt();
                        System.out.print("\t\t\t      Enter the color of the van: ");
                        String colourVan = sc.next();
                        System.out.println("                     ");
                        System.out.println("van added succesfully");
                        //increase number of van by one
                        numOfVan++;

                        entry = new DateTme(day,month,year,hour,minute);    //create dateTime object with status
                        Vehicle vanDetails = new Van(colourVan, brandVan, vehicleId, cargoVolume, entry);

                        // adding van to tha vehicleArraylist
                        if (vanDetails.park()) {
                            vehicleArrayList.add(vanDetails);
                            System.out.println("The number of free slots remaining "+freeslots+" ."); // show number of free slots
                        } else {
                            System.out.println("slots are full, please try in sometime");  //shows this message if parking is full
                        }
                        break;

                    } else {
                        System.out.println("no free slots available for vans");  // shows this message that no enough space for van parking

                    }
                    break;

                case 3:


                    System.out.print(" ");
                    System.out.print("\t\t---------- Add your MotorBike -----------");
                    System.out.print(" ");
                    System.out.println("\n\t\t\t  Enter ID : ");
                    vehicleId = sc.nextInt();
                    System.out.println("\n\t\t\t  Entry Date(Format-Year Month Day : ");
                    System.out.println("\n\t  Year  :");
                    year = sc.nextInt();
                    System.out.println("\n\t  Month  :");
                    month = sc.nextInt();
                    System.out.println("\n\t  Date  :");
                    day = sc.nextInt();
                    System.out.println("\n\t\t\t  Enter Time (HH:MM:SS)");
                    System.out.println("\n\t  Hour  :");
                    hour = sc.nextInt();
                    System.out.println("\n\t  Minute  :");
                    minute = sc.nextInt();
                    System.out.print("\n\t\t\t    Enter the MotorBike brand : ");
                    String brandMotor = sc.next();
                    System.out.print("\t\t\t      Enter the engine size : ");
                    int enginesize = sc.nextInt();
                    System.out.print("\t\t\t      Enter the color of the MotorBike: ");
                    String colourMotor = sc.next();
                    System.out.println("                     ");
                    System.out.println("MotorBike added succesfully");
                    // increase number of motorbikes by one
                    numOfMotorBike++;

                    entry = new DateTme(day,month,year,hour,minute);  //create dateTime object

                    Vehicle motorDetails = new MotorBike(colourMotor, brandMotor, enginesize, vehicleId, entry);

                    //// adding van to tha vehicleArraylist
                    if (motorDetails.park()) {
                        vehicleArrayList.add(motorDetails);
                        System.out.println("The number of free slots remaining "+freeslots+" .");   // show number of free slots
                    } else {
                        System.out.println("slots are full, please try in sometime");   //shows this message if parking is full
                    }
                    break;
            }
        } else {
            System.out.println("no free slots available");  // show message number of free slots available
        }
    }

// vehicle remove method
    private static void removeVehicles() {
        System.out.println(" currently parked vehicles ");

        //display all the current vehicles in the garage
        for (int i = (vehicleArrayList.size()-1); i >=  0; i--) {
            System.out.print((i)+" . ");
            vehicleArrayList.get(i).Display();
        }

        ////asking which vehicle the user wants to remove from park system
        System.out.println("which vehicle do you want to remove from the garage");
        System.out.println("Enter the number next to it");
        int input = sc.nextInt();
        charges(input);

        ////check whether user inputId less than or equal number of vehicle
        if (input <= vehicleArrayList.size()){
            vehicleArrayList.get(input).unpark();  //// get the user input vehicle id from the vehicle arraylist and remove it from the list
            vehicleArrayList.remove(input);
        }else{
            System.out.println("Invalid input.");  // show message invalid input
        }
    }

    ////show all current vehicles in the garage
    private static void showVehicles(){

        System.out.println(" currently parked vehicles ");
        System.out.println("----------------------------");
        System.out.println("                            ");

        //display all vehicles currently parked
        for (int i = (vehicleArrayList.size()-1); i >=  0; i--) {
            System.out.print((i)+" . ");
            vehicleArrayList.get(i).Display();
        }
    }

    ///statistcs of vehicles
    //////check precentage of vehicles
    /////check the last parked vehicle
    private static void statistics() {

        //precentage of currently parked vehicles
        System.out.println("show percentage of vehicles");
        System.out.println(" Percentage Of Cars " + ((double) numOfCar / (double) (Vehicle.numOfVehicle ) * 100) + "%" + "\n Percentage Of Vans " + (numOfVan / (double) (Vehicle.numOfVehicle ) * 100) + "%" + "\n Precentage Of MotorBikes : " + (numOfMotorBike / (double) (Vehicle.numOfVehicle ) * 100) + "%" );

        //The vehicle that was parked the last
        System.out.print("The last parked vehicle is : ");
        vehicleArrayList.get(vehicleArrayList.size()-1).Display();  ///get the last index of vehicle arraylist and display the last parked vehicle

        //TODO vehicle that was parked the longest
        System.out.print("The longest parked vehicle is : ");
        long longest =  0;
        for (Vehicle vehicle : vehicleArrayList){
            if (hoursParked > longest){
                longest = (long) hoursParked;  //cast to long
            }

        }

    }


   //// Prints out the parked vehicles in a given user specified day.
    private static void DetailsOfaSpecificDay() {

        //check whether car park is empty
        if (Vehicle.numOfVehicle <= 0) {
            System.out.println("Car Park is Empty");
        } else {
            //Asking the specific day
            System.out.println("Enter the date You Want to Check(Format-Year Month Day) :- ");
            int year = sc.nextInt();
            int month = sc.nextInt();
            int day = sc.nextInt();

            boolean ifAnythingMatches = true;

            //checking all the vehicles entry date currently in the park
            //the vehicles which user want to know
            for (int i = 0; i < vehicleArrayList.size() ; i++) {
                ///check  vehicles parked on that day
                if (vehicleArrayList.get(i).getDatetime().getYear()== year && vehicleArrayList.get(i).getDatetime().getMonth() == month && vehicleArrayList.get(i).getDatetime().getDay() == day){
                   //use the boolean to print the message one time
                    if (ifAnythingMatches){
                        System.out.println("Vehicles In the day dd/mm/yyyy :" + day+"/"+month+"/"+year);
                    }
                    vehicleArrayList.get(i).Display();  //show vehicles parked on specify day
                    ifAnythingMatches = false;
                }
            }
            ////  print message no vehicles on user input day
            if (ifAnythingMatches){
                System.out.println("Theres is no vehicle on this day dd/mm/yyyy :" + day+"/"+month+"/"+year);
            }
        }
    }

    ////calculate charges

    private static void charges(int i) {
        //check whether carpark is empty
        if (Vehicle.numOfVehicle <= 0) {
            System.out.println("Car Park is Empty");
        } else {
            System.out.println("Enter The vehicle leaving date and Time :- \n");

            //asking for the time which the user wants to calculate fees for
            System.out.println("Time (Hour Minute) : ");
            int hours = sc.nextInt();
            int minutes = sc.nextInt();

            //asking for the date
            System.out.println("Date (Year Month Day) : ");
            int year = sc.nextInt();
            int month = sc.nextInt();
            int day = sc.nextInt();

            int yearDiff =0;
            int monthDiff=0;
            int dayDiff=0;
            int hourDiff=0;
            int minuteDiff=0;

            //checking whether the user input exit date and time validated
            if (vehicleArrayList.get(i).getDatetime().getYear() <= year){
                yearDiff = year - vehicleArrayList.get(i).getDatetime().getYear();
                if (vehicleArrayList.get(i).getDatetime().getMonth() <= month && month < 12){
                    monthDiff = month - vehicleArrayList.get(i).getDatetime().getMonth();
                    if (vehicleArrayList.get(i).getDatetime().getDay() <= day && day < 30){
                        dayDiff = day - vehicleArrayList.get(i).getDatetime().getDay();
                        if (vehicleArrayList.get(i).getDatetime().getHours() < hours){
                            hourDiff = hours - vehicleArrayList.get(i).getDatetime().getHours();
                            if (vehicleArrayList.get(i).getDatetime().getMinutes() < minutes){
                                minuteDiff = minutes - vehicleArrayList.get(i).getDatetime().getMinutes();
                            }else{
                                minuteDiff = 60 - minutes;  //get the difference of minutes
                            }
                        }else{
                            System.out.println("The hours entered is incorrect"); //show message enter hours incorrect
                        }
                    }else{
                        System.out.println("The day entered is incorrect");  //show message enter day incorrect
                    }
                }else{
                    System.out.println("The month entered is incorrect");  //show message enter month incorrect
                }
            }else{
               System.out.println("The year entered is incorrect");  //show message enter year incorrect
            }

            //converting whole date and time into minutes to calculate
            int currentTimeInMinutes = (yearDiff*365*24*60) + (monthDiff*30*24*60) + (dayDiff*24*60) + (hourDiff*60) + minuteDiff;

             hoursParked = currentTimeInMinutes/60;  //convert the time difference into hours

            //check parked hours below 3
            if (hoursParked <= 3 ){
                payment = hoursParked *3;
            }else{
                payment = 9 + (hoursParked -3)*1;
            }
            System.out.println("The price for the hours "+hoursParked+" is : "+payment + "$");  //show bill
        }
    }
}
