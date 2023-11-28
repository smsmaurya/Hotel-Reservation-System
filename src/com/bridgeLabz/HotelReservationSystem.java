package com.bridgeLabz;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;

public class HotelReservationSystem {
    ArrayList<Hotel> hotelList=new ArrayList<>();
    public void addHotel(Hotel hotel) {
        hotelList.add(hotel);
    }

    // task -> show only single cheap hotel
    public Hotel findCheapestHotel(LocalDate startDate, LocalDate endDate) {
        return hotelList.stream()
                .min(Comparator.comparingInt(hotel -> hotel.calculateTotalRate(startDate, endDate)))
                .orElse(null);
    }

    /*task - to show all hotels name which are cheap rate*/
    public ArrayList<Hotel> findCheapestHotels(LocalDate startDate, LocalDate endDate) {
        ArrayList<Hotel> cheapestHotelsList = new ArrayList<>();

        int minTotalCheapRate = Integer.MAX_VALUE;

        for (Hotel hotel : hotelList) {
            int totalRate = hotel.calculateTotalRate(startDate, endDate);
            if (totalRate < minTotalCheapRate) {
                minTotalCheapRate = totalRate;
                cheapestHotelsList.removeAll(cheapestHotelsList);// removeAll() method of list is used to delete all data from the list
                cheapestHotelsList.add(hotel);
            } else if (totalRate == minTotalCheapRate) {
                cheapestHotelsList.add(hotel);
            }
        }
        return cheapestHotelsList;
    }

    public void findCheapWithBestRatedHotelName(LocalDate startDate, LocalDate endDate,int cheapRate){
        ArrayList<Hotel> sastaHotel = findCheapestHotels(startDate, endDate);
        int maxHotelRating = sastaHotel.stream().mapToInt(hotel -> hotel.rating).max().orElse(Integer.MIN_VALUE);
        for (Hotel hotel: sastaHotel){
            if(hotel.rating==maxHotelRating)
                System.out.println(hotel.hotelName+", Rating: "+hotel.rating+" and Total Rates: $"+cheapRate);
        }
    }

    public Hotel findBestRatedHotel(LocalDate startDate, LocalDate endDate) {
        return hotelList.stream()
                .max(Comparator.comparingInt(hotel -> hotel.rating))
                .orElse(null);
    }

    public static void main(String[] args) {
        System.out.println("**********************************WELCOME IN HOTEL RESERVATION SYSTEM**************************************\n");

        HotelReservationSystem hrs = new HotelReservationSystem();

        Hotel lakewood = new Hotel("Lakewood", 110, 90,3);
        Hotel bridgewood = new Hotel("Bridgewood", 150, 50,4);
        Hotel ridgewood = new Hotel("Ridgewood", 220, 150,5);

        hrs.addHotel(lakewood);
        hrs.addHotel(bridgewood);
        hrs.addHotel(ridgewood);

        //local date and time format use to convert string to local date
        LocalDate startDate = LocalDate.parse("2023-11-25", DateTimeFormatter.ISO_LOCAL_DATE);
        LocalDate endDate = LocalDate.parse("2023-11-28", DateTimeFormatter.ISO_LOCAL_DATE);

        Hotel cheapestHotel = hrs.findCheapestHotel(startDate, endDate);
        ArrayList<Hotel> sastaHotal = hrs.findCheapestHotels(startDate,endDate);
        int cheapRate = cheapestHotel.calculateTotalRate(startDate, endDate);
                System.out.print("Cheapest Hotels are : ");
        for (Hotel cheapHotel:sastaHotal){
            System.out.print(cheapHotel.hotelName+", ");
        }
        System.out.print("Total rate :$"+cheapRate+"\n");

        //find cheap price and best rated hotel in given date range
        hrs.findCheapWithBestRatedHotelName(startDate,endDate,cheapRate);

        //find best rated hotel from given date range
        Hotel bestRatedHotel = hrs.findBestRatedHotel(startDate, endDate);
        System.out.println("Best Rated Hotel: " + bestRatedHotel.hotelName + ", Rating: " + bestRatedHotel.rating);

    }
}