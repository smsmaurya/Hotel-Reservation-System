package com.bridgeLabz;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class HotelReservationSystem {

    ArrayList<Hotel> hotelList=new ArrayList<>();
    public void addHotel(Hotel hotel) { hotelList.add(hotel); }

    // task -> show only single cheap hotel
    public Hotel findCheapestHotel(LocalDate startDate, LocalDate endDate,String customerType) {
        return hotelList.stream()
                .min(Comparator.comparingInt(hotel -> hotel.calculateTotalRateForRegularCustomer(startDate, endDate,customerType)))
                .orElse(null);
    }

    public Hotel findBestRatedHotel() {
        return hotelList.stream()
                .max(Comparator.comparingInt(hotel -> hotel.rating))
                .orElse(null);
    }

    /*task - to show all hotels name which are cheap rate*/
    public ArrayList<Hotel> findCheapestHotels(LocalDate startDate, LocalDate endDate,String customerType) {
        ArrayList<Hotel> cheapestHotelsList = new ArrayList<>();

        int minTotalCheapRate = Integer.MAX_VALUE;

        for (Hotel hotel : hotelList) {
            int totalRate = hotel.calculateTotalRateForRegularCustomer(startDate, endDate,customerType);
            if (totalRate < minTotalCheapRate) {
                minTotalCheapRate = totalRate;
                cheapestHotelsList.clear();// removeAll() or clear() method of list is used to delete all data from the list
                cheapestHotelsList.add(hotel);
            } else if (totalRate == minTotalCheapRate) {
                cheapestHotelsList.add(hotel);
            }
        }
        return cheapestHotelsList;
    }

    // find the cheapest hotel with the best hotel rating
    public void findCheapWithBestRatedHotelName(LocalDate startDate, LocalDate endDate,int cheapRate,String customerType){
        ArrayList<Hotel> sastaHotel = findCheapestHotels(startDate, endDate,customerType);
        int maxHotelRating = sastaHotel.stream().mapToInt(hotel -> hotel.rating).max().orElse(Integer.MIN_VALUE);
        for (Hotel hotel: sastaHotel){
            if(hotel.rating==maxHotelRating)
                System.out.println(hotel.hotelName+", Rating: "+hotel.rating+" and Total Rates: $"+cheapRate);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("**********************************WELCOME IN HOTEL RESERVATION SYSTEM**************************************\n");

        HotelReservationSystem hrs = new HotelReservationSystem();
        Hotel lakewood = new Hotel("Lakewood", 110, 90, 80, 80, 3);
        Hotel bridgewood = new Hotel("Bridgewood", 150, 50, 60, 50, 4);
        Hotel ridgewood = new Hotel("Ridgewood", 220, 150, 150, 40, 5);
        hrs.addHotel(lakewood);
        hrs.addHotel(bridgewood);
        hrs.addHotel(ridgewood);

        System.out.println("Enter customer type ('Regular' or 'Reward') :");
        String customerType = scan.next();
        if(customerType.equalsIgnoreCase("Regular")|| customerType.equalsIgnoreCase("Reward")){}
        else
            System.out.println(customerType + " is not valid customer");

        //local date and time format use to convert string to local date
        LocalDate startDate = LocalDate.parse("2023-11-25", DateTimeFormatter.ISO_LOCAL_DATE);
        LocalDate endDate = LocalDate.parse("2023-11-28", DateTimeFormatter.ISO_LOCAL_DATE);

        Hotel cheapestHotel = hrs.findCheapestHotel(startDate, endDate,customerType);
        ArrayList<Hotel> sastaHotal = hrs.findCheapestHotels(startDate,endDate,customerType);
        int cheapRate = cheapestHotel.calculateTotalRateForRegularCustomer(startDate, endDate,customerType);
                System.out.print("Cheapest Hotels are : ");
        for (Hotel cheapHotel:sastaHotal){
            System.out.print(cheapHotel.hotelName+", ");
        }
        System.out.print("Total rate :$"+cheapRate+"\n");

        //find cheap price and best rated hotel in given date range
        hrs.findCheapWithBestRatedHotelName(startDate,endDate,cheapRate,customerType);

        //find best rated hotel from given date range
        Hotel bestRatedHotel = hrs.findBestRatedHotel();
        System.out.println("Best Rated Hotel: " + bestRatedHotel.hotelName + ", Rating: " + bestRatedHotel.rating+", Total rate :"+bestRatedHotel.calculateTotalRateForRegularCustomer(startDate,endDate,customerType));

    }
}