package com.example.AEPB;

//import org.junit.Test;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class ParkingLotTest {

    //有空位 && 停车场无此车
    @Test
    void should_return_ticket_when_park_given_lot_and_car() {
        ParkingLot lot = new ParkingLot(10);
        Car car = new Car("ABCDEF");
        Ticket ticket = lot.park(car);

        assertNotNull(ticket);
    }

    //有空位 && 停车场有此车
    @Test
    void should_not_return_ticket_when_park_given_lot_and_Duplicated_car() {
        ParkingLot lot = new ParkingLot(10);
        String plateNum = "ABCDEF";
        lot.park(new Car(plateNum));
        Ticket ticket = lot.park(new Car(plateNum));

        assertNull(ticket);
    }

    //无空位
    @Test
    void should_return_null_when_park_given_full_lot_and_car() {
        ParkingLot lot = new ParkingLot(1);
        lot.park(new Car("ABCDEF"));
        Ticket ticket = lot.park(new Car("BCDEFG"));

        assertNull(ticket);
    }

    //无车牌
    @Test
    void should_return_null_when_park_given_lot_and_invalid_car() {
        ParkingLot lot = new ParkingLot(1);
        Car car = new Car(null);
        Ticket ticket = lot.park(car);

        assertNull(ticket);
    }

    //有效票离场
    @Test
    void should_return_car_when_pick_given_lot_and_ticket() {
        ParkingLot lot = new ParkingLot(1);
        String plateNum = "ABCDEF";
        lot.park(new Car(plateNum));
        Ticket ticket = new Ticket(plateNum);
        Car car = lot.pick(ticket);

        assertNotNull(car);
    }

    //不出示车票离场
    @Test
    void should_return_null_when_pick_given_lot_and_invalid_ticket() {
        ParkingLot lot = new ParkingLot(1);
        String plateNum = "ABCDEF";
        lot.park(new Car(plateNum));
        Ticket ticket = new Ticket(null);
        Car car = lot.pick(ticket);

        assertNull(car);
    }

    //无效票离场
    @Test
    void should_return_null_when_pick_given_lot_and_not_exist_ticket() {
        ParkingLot lot = new ParkingLot(1);
        String plateNum = "ABCDEF";
        lot.park(new Car(plateNum));
        Ticket ticket = new Ticket("BCDEFG");
        Car car = lot.pick(ticket);

        assertNull(car);
    }

}
