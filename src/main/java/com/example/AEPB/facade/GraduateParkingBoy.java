package com.example.AEPB.facade;

import com.example.AEPB.common.ParkTemplate;
import com.example.AEPB.common.ParkingLotStrategy;
import com.example.AEPB.common.PickTemplate;
import com.example.AEPB.domain.Car;
import com.example.AEPB.domain.ParkingLot;
import com.example.AEPB.domain.Ticket;

import java.util.*;

public class GraduateParkingBoy {

    protected List<ParkingLot> parkingLotList;

    public GraduateParkingBoy(List<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;
    }

    public Ticket park(Car car) {
        return new ParkTemplate().park(this.parkingLotList, car, strategy());
    }

    public Car pick(Ticket ticket) {
        return new PickTemplate().pick(this.parkingLotList, ticket);
    }

    private ParkingLotStrategy strategy() {
        return parkingLots -> parkingLots.stream()
                .filter(ParkingLot::isNotFull)
                .findFirst()
                .orElse(null);
    }

}
