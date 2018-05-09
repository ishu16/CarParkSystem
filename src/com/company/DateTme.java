
package com.company;


public class DateTme {

//instance variables
    private int day;
    private int month;
    private int year;
    private int minutes;
    private int hours;

    ///constructor
    public DateTme(int day, int month, int year, int hours, int minutes) {
        super();
        this.day = day;
        this.month = month;
        this.year = year;
        this.hours = hours;
        this.minutes = minutes;
    }

    //getters
    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getHours() {
        return hours;
    }

    public String getDate(){
        return "Date : " + day + "/" + month + "/" +year + "  Time : " + hours + ":" + minutes;
    }


}


