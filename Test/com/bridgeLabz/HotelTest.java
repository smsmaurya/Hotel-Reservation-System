package com.bridgeLabz;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class HotelTest {

    @org.junit.jupiter.api.Test
    void calculateTotalRateForRegularCustomer() {
        Hotel hotel = new Hotel("Lakewood", 110, 90, 80, 80, 3);

        LocalDate startDate = LocalDate.of(2023, 12, 2);
        LocalDate endDate = LocalDate.of(2023, 12, 5);

        int totalRate = hotel.calculateTotalRateForRegularCustomer(startDate, endDate, "Regular");
        assertEquals(400, totalRate);
    }
}