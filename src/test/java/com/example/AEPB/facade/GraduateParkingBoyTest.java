package com.example.AEPB.facade;

import com.example.AEPB.common.ParkingLotsBuilder;
import com.example.AEPB.domain.Car;
import com.example.AEPB.domain.ParkingLot;
import com.example.AEPB.domain.Ticket;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class GraduateParkingBoyTest {

    @Test
    void should_return_ticket_when_park_given_plotA_is_not_full_and_valid_car() {
        GraduateParkingBoy boy = new GraduateParkingBoy(ParkingLotsBuilder.buildParkingLots(10));
        Car car = new Car("ABCDEF");
        Ticket ticket = boy.park(car);

        assertNotNull(ticket);
    }

    @Test
    void should_return_ticket_when_park_given_plotA_is_full_and_plotB_is_not_full_and_valid_car() {
        GraduateParkingBoy boy = new GraduateParkingBoy(ParkingLotsBuilder.buildParkingLots(1));
        boy.park(new Car("ABCDEF"));
        Ticket ticket = boy.park(new Car("BCDEFG"));

        assertNotNull(ticket);
    }

    @Test
    void should_park_in_plotB_given_plotA_is_full_and_plotB_is_not_full_and_valid_car() {
        List<ParkingLot> parkingLotList = ParkingLotsBuilder.buildParkingLots(1);
        GraduateParkingBoy boy = new GraduateParkingBoy(parkingLotList);
        boy.park(new Car("ABCDEF"));
        Ticket ticket = boy.park(new Car("BCDEFG"));
        Car car = parkingLotList.get(1).pick(ticket);

        assertNotNull(car);
    }

    @Test
    void should_return_ticket_when_park_given_plotA_and_plotB_are_full_and_plotC_is_not_full_and_valid_car() {
        GraduateParkingBoy boy = new GraduateParkingBoy(ParkingLotsBuilder.buildParkingLots(1));
        boy.park(new Car("ABCDEF"));
        boy.park(new Car("CDEFGH"));
        Ticket ticket = boy.park(new Car("AAAAAA"));

        assertNotNull(ticket);
    }

    @Test
    void should_park_in_plotC_given_plotA_and_plotB_are_full_and_plotC_is_not_full_and_valid_car() {
        List<ParkingLot> parkingLotList = ParkingLotsBuilder.buildParkingLots(1);
        GraduateParkingBoy boy = new GraduateParkingBoy(parkingLotList);
        boy.park(new Car("ABCDEF"));
        boy.park(new Car("CDEFGH"));
        Ticket ticket = boy.park(new Car("AAAAAA"));
        Car car = parkingLotList.get(2).pick(ticket);

        assertNotNull(car);
    }

    @Test
    void should_return_null_when_park_given_duplicated_car() {
        GraduateParkingBoy boy = new GraduateParkingBoy(ParkingLotsBuilder.buildParkingLots(10));
        String carPlateNum = "ABCDEF";
        boy.park(new Car(carPlateNum));
        Ticket ticket = boy.park(new Car(carPlateNum));

        assertNull(ticket);
    }

    @Test
    void should_return_car_when_pick_given_ticket() {
        GraduateParkingBoy boy = new GraduateParkingBoy(ParkingLotsBuilder.buildParkingLots(10));
        Ticket ticket = boy.park(new Car("ABCDEF"));
        Car car = boy.pick(ticket);

        assertNotNull(car);
    }

    @Test
    void should_return_null_when_pick_given_invalid_ticket() {
        GraduateParkingBoy boy = new GraduateParkingBoy(ParkingLotsBuilder.buildParkingLots(10));
        boy.park(new Car("ABCDEF"));
        Ticket ticket = new Ticket("BCDEFG");
        Car car = boy.pick(ticket);

        assertNull(car);
    }

}
