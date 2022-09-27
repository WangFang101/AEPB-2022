package com.example.AEPB;

import java.util.*;

public class SmartParkingBoy {

    private List<ParkingLot> parkingLots = new ArrayList<>();

    public SmartParkingBoy(ParkingLot... parkingLots) {
        this.parkingLots.addAll(Arrays.asList(parkingLots));
    }

    public Ticket park(Car car) {
        ParkingLot parkingLot = parkingLots.stream().max(Comparator.comparingInt(ParkingLot::getPlotLeftCapacity)).orElse(new ParkingLot(0));
        if (0 == parkingLot.getPlotLeftCapacity()) {
            return null;
        }

        return parkingLot.park(car);
    }

    public Car pick(Ticket ticket) {
        return parkingLots.stream().map(parkingLot -> parkingLot.pick(ticket))
                .filter(Objects::nonNull).findFirst().orElse(null);
    }


}


