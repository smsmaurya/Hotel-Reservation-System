package com.bridgeLabz;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Hotel {
    String hotelName;
    int weekdayRateForRegularCustomer,weekendRateForRegularCustomer, weekdayRateForRewardCustomer,weekendRateForRewardCustomer, rating;

    public Hotel(String hotelName, int weekdayRateForRegularCustomer,int weekendRateForRegularCustomer, int rating,int weekdayRateForRewardCustomer,int weekendRateForRewardCustomer) {
        this.hotelName = hotelName;
        this.weekdayRateForRegularCustomer = weekdayRateForRegularCustomer;
        this.weekendRateForRegularCustomer = weekendRateForRegularCustomer;
        this.weekdayRateForRewardCustomer = weekdayRateForRewardCustomer;
        this.weekendRateForRewardCustomer = weekendRateForRewardCustomer;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "hotelName='" + hotelName + '\'' +
                ", weekdayRegularCustomer=" + weekdayRateForRegularCustomer + '\'' +
                ", weekendRegularCustomer=" + weekendRateForRegularCustomer +'\'' +
                ", weekdayRewardCustomer="+ weekdayRateForRewardCustomer+'\'' +
                ", weekendRewardCustomer="+ weekendRateForRewardCustomer+ '\'' +
                ", rating='" + rating +
                '}';
    }

    public int calculateTotalRate(LocalDate startDate, LocalDate endDate) {
        int totalRate = 0;
        while (!startDate.isAfter(endDate)) {
            if (startDate.getDayOfWeek() == DayOfWeek.SATURDAY || startDate.getDayOfWeek() == DayOfWeek.SUNDAY) {
                totalRate += weekendRateForRegularCustomer;
            } else {
                totalRate += weekdayRateForRegularCustomer;
            }
            startDate = startDate.plusDays(1);
        }
        return totalRate;
    }
}