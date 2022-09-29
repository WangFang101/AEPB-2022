package com.example.AEPB.facade;

import com.example.AEPB.common.ParkingLotsBuilder;
import com.example.AEPB.domain.Car;
import com.example.AEPB.domain.ParkingLot;
import com.example.AEPB.domain.Ticket;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class SmartParkingBoyTest {

    @Test
    void should_park_in_plotA_when_park_given_plotA_left_capacity_max() {
        List<ParkingLot> parkingLotList = ParkingLotsBuilder.buildParkingLots(10);
        SmartParkingBoy boy = new SmartParkingBoy(parkingLotList);
        parkingLotList.get(1).park(new Car("BBBBBB"));
        parkingLotList.get(2).park(new Car("CCCCCC"));

        Ticket ticket = boy.park(new Car("AAAAAA"));
        Car car = parkingLotList.get(0).pick(ticket);

        assertNotNull(car);
    }

    @Test
    void should_park_in_plotA_when_park_given_plotA_eq_plotB_and_gt_plotC() {
        List<ParkingLot> parkingLotList = ParkingLotsBuilder.buildParkingLots(10);
        SmartParkingBoy boy = new SmartParkingBoy(parkingLotList);
        parkingLotList.get(2).park(new Car("CCCCCC"));

        Ticket ticket = boy.park(new Car("AAAAAA"));
        Car car = parkingLotList.get(0).pick(ticket);

        assertNotNull(car);
    }

    @Test
    void should_park_in_plotA_when_park_given_left_capacity_plotA_eq_plotB_eq_plotC() {
        List<ParkingLot> parkingLotList = ParkingLotsBuilder.buildParkingLots(10);
        SmartParkingBoy boy = new SmartParkingBoy(parkingLotList);

        Ticket ticket = boy.park(new Car("AAAAAA"));
        Car car = parkingLotList.get(0).pick(ticket);

        assertNotNull(car);

    }

    @Test
    void should_return_car_when_pick_given_car_in_ParkingPlot_and_valid_ticket() {
        SmartParkingBoy boy = new SmartParkingBoy(ParkingLotsBuilder.buildParkingLots(10));

        Ticket ticket = boy.park(new Car("AAAAAA"));
        Car car = boy.pick(ticket);

        assertNotNull(car);
    }

    @Test
    void should_not_return_car_when_pick_given_car_in_ParkingPlot_and_invalid_ticket() {
        SmartParkingBoy boy = new SmartParkingBoy(ParkingLotsBuilder.buildParkingLots(10));

        boy.park(new Car("AAAAAA"));
        Ticket ticket = new Ticket("BBBBBB");
        Car car = boy.pick(ticket);

        assertNull(car);
    }

    @Test
    void should_not_return_car_when_pick_given_car_in_ParkingPlot_and_without_ticket() {
        SmartParkingBoy boy = new SmartParkingBoy(ParkingLotsBuilder.buildParkingLots(10));

        boy.park(new Car("AAAAAA"));
        Ticket ticket = new Ticket(null);
        Car car = boy.pick(ticket);

        assertNull(car);
    }

}


