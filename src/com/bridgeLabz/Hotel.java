package com.bridgeLabz;

public class Hotel {
    String hotelName;
    int weekdayRegularCustomer;

    public Hotel(String hotelName, int regularCustomer) {
        this.hotelName = hotelName;
        this.weekdayRegularCustomer = regularCustomer;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "hotelName='" + hotelName + '\'' +
                ", regularCustomer=" + weekdayRegularCustomer +
                '}';
    }

}
