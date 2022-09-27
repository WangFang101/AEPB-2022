package com.example.AEPB;

import java.util.Comparator;

public class SmartParkingBoy extends GraduateParkingBoy {

    public SmartParkingBoy(ParkingLot... parkingLots) {
        super(parkingLots);
    }

    @Override
    public Ticket park(Car car) {
        ParkingLot parkingLot = getParkingLots().stream().max(Comparator.comparingInt(ParkingLot::getPlotLeftCapacity)).orElse(new ParkingLot(0));
        if (0 == parkingLot.getPlotLeftCapacity()) {
            return null;
        }

        return parkingLot.park(car);
    }

}
