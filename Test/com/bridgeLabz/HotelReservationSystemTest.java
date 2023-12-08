package com.bridgeLabz;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class HotelReservationSystemTest {

    @Test
    void findCheapestHotel() {
        HotelReservationSystem hrs = new HotelReservationSystem();
        Hotel lakewood = new Hotel("Lakewood", 110, 90, 80, 80, 3);
        Hotel bridgewood = new Hotel("Bridgewood", 150, 50, 60, 50, 4);
        Hotel ridgewood = new Hotel("Ridgewood", 220, 150, 150, 40, 5);

        hrs.addHotel(lakewood);
        hrs.addHotel(bridgewood);
        hrs.addHotel(ridgewood);

        LocalDate startDate = LocalDate.parse("2023-11-25");
        LocalDate endDate = LocalDate.parse("2023-11-28");
        String customerType = "Regular";

        Hotel cheapestHotel = hrs.findCheapestHotel(startDate, endDate, customerType);

        assertNotNull(cheapestHotel);
        assertEquals("Lakewood", cheapestHotel.hotelName);
    }

    @Test
    void findBestRatedHotel() {
        HotelReservationSystem hrs = new HotelReservationSystem();
        Hotel lakewood = new Hotel("Lakewood", 110, 90, 80, 80, 3);
        Hotel bridgewood = new Hotel("Bridgewood", 150, 50, 60, 50, 4);
        Hotel ridgewood = new Hotel("Ridgewood", 220, 150, 150, 40, 5);

        hrs.addHotel(lakewood);
        hrs.addHotel(bridgewood);
        hrs.addHotel(ridgewood);

        Hotel bestRatedHotel = hrs.findBestRatedHotel();

        assertNotNull(bestRatedHotel);
        assertEquals("Ridgewood", bestRatedHotel.hotelName);
    }

    @Test
    void findCheapestHotels() {
        HotelReservationSystem hrs = new HotelReservationSystem();
        Hotel lakewood = new Hotel("Lakewood", 110, 90, 80, 80, 3);
        Hotel bridgewood = new Hotel("Bridgewood", 150, 50, 60, 50, 4);
        Hotel ridgewood = new Hotel("Ridgewood", 220, 150, 150, 40, 5);

        hrs.addHotel(lakewood);
        hrs.addHotel(bridgewood);
        hrs.addHotel(ridgewood);

        LocalDate startDate = LocalDate.parse("2023-11-25");
        LocalDate endDate = LocalDate.parse("2023-11-28");
        String customerType = "Regular";

        ArrayList<Hotel> cheapestHotels = hrs.findCheapestHotels(startDate, endDate, customerType);

        assertNotNull(cheapestHotels);
        assertEquals(2, cheapestHotels.size());
        assertEquals("Lakewood", cheapestHotels.get(0).hotelName);
    }
}