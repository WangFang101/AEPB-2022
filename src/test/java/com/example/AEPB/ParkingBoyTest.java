package com.example.AEPB;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class ParkingBoyTest {

    @Test
    void should_return_ticket_when_park_given_plotA_is_not_full_and_valid_car() {
        int size = 10;
        ParkingBoy boy = new ParkingBoy(new ParkingLot(size), new ParkingLot(size), new ParkingLot(size));
        Car car = new Car("ABCDEF");
        Ticket ticket = boy.park(car);

        assertNotNull(ticket);
    }

    @Test
    void should_return_ticket_when_park_given_plotA_is_full_and_plotB_is_not_full_and_valid_car() {
        int size = 1;
        ParkingBoy boy = new ParkingBoy(new ParkingLot(size), new ParkingLot(size), new ParkingLot(size));
        boy.park(new Car("ABCDEF"));
        Ticket ticket = boy.park(new Car("BCDEFG"));

        assertNotNull(ticket);
    }

    @Test
    void should_park_in_plotB_given_plotA_is_full_and_plotB_is_not_full_and_valid_car() {
        int size = 1;
        ParkingLot parkingLotA = new ParkingLot(size);
        ParkingLot parkingLotB = new ParkingLot(size);
        ParkingLot parkingLotC = new ParkingLot(size);
        ParkingBoy boy = new ParkingBoy(parkingLotA, parkingLotB, parkingLotC);
        boy.park(new Car("ABCDEF"));
        Ticket ticket = boy.park(new Car("BCDEFG"));
        Car car = parkingLotB.pick(ticket);

        assertNotNull(car);
    }

    @Test
    void should_return_null_when_park_given_duplicated_car() {
        int size = 10;
        ParkingBoy boy = new ParkingBoy(new ParkingLot(size), new ParkingLot(size), new ParkingLot(size));
        String carPlateNum = "ABCDEF";
        boy.park(new Car(carPlateNum));
        Ticket ticket = boy.park(new Car(carPlateNum));

        assertNull(ticket);
    }

    @Test
    void should_return_car_when_pick_given_ticket() {
        int size = 10;
        ParkingBoy boy = new ParkingBoy(new ParkingLot(size), new ParkingLot(10), new ParkingLot(10));
        Ticket ticket = boy.park(new Car("ABCDEF"));
        Car car = boy.pick(ticket);

        assertNotNull(car);
    }

    @Test
    void should_return_null_when_pick_given_invalid_ticket() {
        int size = 10;
        ParkingBoy boy = new ParkingBoy(new ParkingLot(size), new ParkingLot(size), new ParkingLot(size));
        boy.park(new Car("ABCDEF"));
        Ticket ticket = new Ticket("BCDEFG");
        Car car = boy.pick(ticket);

        assertNull(car);
    }

}
