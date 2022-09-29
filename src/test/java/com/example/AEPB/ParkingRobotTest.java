package com.example.AEPB;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class ParkingRobotTest {

    @Test
    void should_park_A_when_park_given_A_vacancy_rate_max() {
        int size = 5;
        ParkingLot parkingLotA = new ParkingLot(size);
        ParkingLot parkingLotB = new ParkingLot(size);
        ParkingLot parkingLotC = new ParkingLot(size);
        ParkingRobot parkingRobot = new ParkingRobot(parkingLotA, parkingLotB, parkingLotC);
        parkingLotB.park(new Car("ABCDEF"));
        parkingLotC.park(new Car("BCDEFG"));
        parkingLotC.park(new Car("CDEFGH"));

        Ticket ticket = parkingRobot.park(new Car("DEFGHI"));
        Car car = parkingLotA.pick(ticket);

        assertNotNull(car);
    }



}
