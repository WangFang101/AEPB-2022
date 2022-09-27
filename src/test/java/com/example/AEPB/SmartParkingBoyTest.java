package com.example.AEPB;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SmartParkingBoyTest {

    @Test
    void should_park_in_plotA_when_park_given_plotA_left_capacity_max() {

        int size = 10;
        ParkingLot ParkingPlotA = new ParkingLot(size);
        ParkingLot ParkingPlotB = new ParkingLot(size);
        ParkingLot ParkingPlotC = new ParkingLot(size);
        SmartParkingBoy boy = new SmartParkingBoy(ParkingPlotA, ParkingPlotB, ParkingPlotC);
        ParkingPlotB.park(new Car("BBBBBB"));
        ParkingPlotC.park(new Car("CCCCCC"));

        Ticket ticket = boy.park(new Car("AAAAAA"));
        Car car = ParkingPlotA.pick(ticket);

        assertNotNull(car);
    }

    @Test
    void should_park_in_plotA_when_park_given_plotA_eq_plotB_and_gt_plotC() {

        int size = 10;
        ParkingLot ParkingPlotA = new ParkingLot(size);
        ParkingLot ParkingPlotB = new ParkingLot(size);
        ParkingLot ParkingPlotC = new ParkingLot(size);
        SmartParkingBoy boy = new SmartParkingBoy(ParkingPlotA, ParkingPlotB, ParkingPlotC);
        ParkingPlotC.park(new Car("CCCCCC"));

        Ticket ticket = boy.park(new Car("AAAAAA"));
        Car car = ParkingPlotA.pick(ticket);

        assertNotNull(car);
    }





}


