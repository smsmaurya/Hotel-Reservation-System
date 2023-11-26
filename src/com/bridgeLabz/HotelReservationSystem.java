package com.bridgeLabz;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;

public class HotelReservationSystem {
    ArrayList<Hotel> hotelList=new ArrayList<>();
    public void addHotel(Hotel hotel) {hotelList.add(hotel);}

    public Hotel findCheapestHotel(LocalDate startDate, LocalDate endDate) {
        return hotelList.stream()
                .min(Comparator.comparingInt(hotel -> hotel.calculateTotalRate(startDate, endDate)))
                .orElse(null);
    }

    public static void main(String[] args) {
        System.out.println("**********************************WELCOME IN HOTEL RESERVATION SYSTEM**************************************\n");

        HotelReservationSystem hrs = new HotelReservationSystem();

        Hotel lakewood = new Hotel("Lakewood", 110, 90);
        Hotel bridgewood = new Hotel("Bridgewood", 160, 60);
        Hotel ridgewood = new Hotel("Ridgewood", 220, 150);

        hrs.addHotel(lakewood);
        hrs.addHotel(bridgewood);
        hrs.addHotel(ridgewood);

        LocalDate startDate = LocalDate.parse("2023-11-23", DateTimeFormatter.ISO_LOCAL_DATE);
        LocalDate endDate = LocalDate.parse("2023-11-26", DateTimeFormatter.ISO_LOCAL_DATE);

        Hotel cheapestHotel = hrs.findCheapestHotel(startDate, endDate);
        int totalRate = cheapestHotel.calculateTotalRate(startDate, endDate);

        System.out.println("Cheapest Hotel: " + cheapestHotel.hotelName + ", Total Rates: $" + totalRate);
    }
}
