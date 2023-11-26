package com.bridgeLabz;

import java.util.ArrayList;

public class HotelReservationSystem {
    ArrayList<Hotel> hotelList=new ArrayList<>();
    public static void main(String[] args) {
        System.out.println("**********************************WELCOME IN HOTEL RESERVATION SYSTEM**************************************\n");
        Hotel Lakewood = new Hotel( "Lakewood", 110);
        Hotel Bridgewood = new Hotel( "Bridgewood", 160);
        Hotel Ridgewood = new Hotel("Ridgewood", 220);
        HotelReservationSystem hrs = new HotelReservationSystem();
        hrs.hotelList.add(Lakewood);
        hrs.hotelList.add(Bridgewood);
        hrs.hotelList.add(Ridgewood);
        hrs.hotelList.forEach(System.out::println);
    }
}
