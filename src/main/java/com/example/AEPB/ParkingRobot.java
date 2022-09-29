package com.example.AEPB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ParkingRobot {

    private List<ParkingLot> parkingLotList = new ArrayList<>();

    public ParkingRobot(ParkingLot... parkingLots) {
        parkingLotList.addAll(Arrays.asList(parkingLots));
    }

    public Ticket park(Car car) {
        ParkingLot parkingLot = parkingLotList.stream()
                .max(Comparator.comparing(ParkingLot::calVacancyRate))
                .orElse(new ParkingLot(0));

        if (0 == parkingLot.getPlotLeftCapacity()) {
            return null;
        }

        return parkingLot.park(car);
    }

}
