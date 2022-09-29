package com.example.AEPB.facade;

import com.example.AEPB.common.ParkTemplate;
import com.example.AEPB.common.ParkingLotStrategy;
import com.example.AEPB.domain.Car;
import com.example.AEPB.domain.ParkingLot;
import com.example.AEPB.domain.Ticket;

import java.util.Comparator;
import java.util.List;

public class ParkingRobot {

    private List<ParkingLot> parkingLotList;

    public ParkingRobot(List<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;
    }

    public Ticket park(Car car) {
        return new ParkTemplate().park(this.parkingLotList, car, strategy());
    }

    private ParkingLotStrategy strategy() {
        return parkingLots -> parkingLots.stream()
                .max(Comparator.comparing(ParkingLot::calVacancyRate))
                .orElse(null);
    }

}
