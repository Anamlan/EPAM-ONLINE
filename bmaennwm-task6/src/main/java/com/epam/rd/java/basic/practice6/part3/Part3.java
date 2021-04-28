package com.epam.rd.java.basic.practice6.part3;

import com.epam.rd.java.basic.practice6.Demo;

public class Part3 {

    public static void main(String[] args) {
        Parking parking = new Parking(4);
        Demo.print(parking.arrive(2));
        parking.print();
        Demo.print(parking.arrive(3));
        parking.print();
        Demo.print(parking.arrive(2));
        parking.print();
        Demo.print(parking.arrive(2));
        parking.print();
        Demo.print(parking.arrive(2));
        parking.print();
        Demo.print(parking.depart(1));
        parking.print();
        Demo.print(parking.depart(1));
        parking.print();
    }
}
