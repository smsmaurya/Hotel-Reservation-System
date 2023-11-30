package com.bridgeLabz;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Hotel {
    String hotelName;
    int weekdayRateForRegularCustomer,weekendRateForRegularCustomer, weekdayRateForRewardCustomer,weekendRateForRewardCustomer, rating;

    public Hotel(String hotelName, int weekdayRateForRegularCustomer,int weekendRateForRegularCustomer,int weekdayRateForRewardCustomer,int weekendRateForRewardCustomer, int rating) {
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

    public int calculateTotalRateForRegularCustomer(LocalDate startDate, LocalDate endDate,String customerType) {
        int totalRate = 0;
        if(customerType.equalsIgnoreCase("Regular")) {
            while (!startDate.isAfter(endDate)) {
                if (startDate.getDayOfWeek() == DayOfWeek.SATURDAY || startDate.getDayOfWeek() == DayOfWeek.SUNDAY) {
                    totalRate += weekendRateForRegularCustomer;
                } else {
                    totalRate += weekdayRateForRegularCustomer;
                }
                startDate = startDate.plusDays(1);
            }
        }
        else if(customerType.equalsIgnoreCase("Reward")){
            while (!startDate.isAfter(endDate)) {
                if (startDate.getDayOfWeek() == DayOfWeek.SATURDAY || startDate.getDayOfWeek() == DayOfWeek.SUNDAY) {
                    totalRate += weekendRateForRewardCustomer;
                } else {
                    totalRate += weekdayRateForRewardCustomer;
                }
                startDate = startDate.plusDays(1);
            }
        }
        return totalRate;
    }
}