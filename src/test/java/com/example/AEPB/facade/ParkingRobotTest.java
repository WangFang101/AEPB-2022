package com.example.AEPB.facade;

import com.example.AEPB.common.ParkingLotsBuilder;
import com.example.AEPB.domain.Car;
import com.example.AEPB.domain.ParkingLot;
import com.example.AEPB.domain.Ticket;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class ParkingRobotTest {

    @Test
    void should_park_A_when_park_given_A_vacancy_rate_max() {
        List<ParkingLot> parkingLotList = ParkingLotsBuilder.buildParkingLots(5);
        ParkingRobot parkingRobot = new ParkingRobot(parkingLotList);
        parkingLotList.get(1).park(new Car("ABCDEF"));
        parkingLotList.get(1).park(new Car("BCDEFG"));
        parkingLotList.get(2).park(new Car("CDEFGH"));

        Ticket ticket = parkingRobot.park(new Car("DEFGHI"));
        Car car = parkingLotList.get(0).pick(ticket);

        assertNotNull(car);
    }

    @Test
    void should_park_A_when_park_given_A_B_vacancy_rate_eq_and_gt_C() {
        List<ParkingLot> parkingLotList = ParkingLotsBuilder.buildParkingLots(5);
        ParkingRobot parkingRobot = new ParkingRobot(parkingLotList);
        parkingLotList.get(2).park(new Car("BCDEFG"));
        parkingLotList.get(2).park(new Car("CDEFGH"));

        Ticket ticket = parkingRobot.park(new Car("ABCDEF"));
        Car car = parkingLotList.get(0).pick(ticket);

        assertNotNull(car);
    }

    @Test
    void should_park_A_when_park_given_A_B_C_vacancy_rate_eq() {
        List<ParkingLot> parkingLotList = ParkingLotsBuilder.buildParkingLots(5);
        ParkingRobot parkingRobot = new ParkingRobot(parkingLotList);

        Ticket ticket = parkingRobot.park(new Car("ABCDEF"));
        Car car = parkingLotList.get(0).pick(ticket);

        assertNotNull(car);
    }

    @Test
    void should_park_fail_when_park_given_A_B_C_vacancy_rate_eq_0() {
        List<ParkingLot> parkingLotList = ParkingLotsBuilder.buildParkingLots(1);
        ParkingRobot parkingRobot = new ParkingRobot(parkingLotList);
        parkingLotList.get(0).park(new Car("ABCDEF"));
        parkingLotList.get(1).park(new Car("BCDEFG"));
        parkingLotList.get(2).park(new Car("CDEFGH"));


        Ticket ticket = parkingRobot.park(new Car("ABCDEF"));

        assertNull(ticket);
    }

    @Test
    void should_park_A_when_park_given_A_B_C_vacancy_rate_eq_and_duplicated_car() {
        ParkingRobot parkingRobot = new ParkingRobot(ParkingLotsBuilder.buildParkingLots(5));

        String plateNum = "ABCDEF";
        parkingRobot.park(new Car(plateNum));
        Ticket ticket = parkingRobot.park(new Car(plateNum));

        assertNull(ticket);
    }

    @Test
    void should_park_fail_when_park_given_invalid_car() {
        ParkingRobot parkingRobot = new ParkingRobot(ParkingLotsBuilder.buildParkingLots(5));

        Ticket ticket = parkingRobot.park(new Car(null));;

        assertNull(ticket);
    }

}
