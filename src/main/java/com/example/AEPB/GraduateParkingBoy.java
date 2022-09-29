package com.example.AEPB;

import java.util.*;

public class GraduateParkingBoy {

     List<ParkingLot> parkingLots = new ArrayList<>();

    public GraduateParkingBoy(ParkingLot... parkingLots) {
        this.parkingLots.addAll(Arrays.asList(parkingLots));
    }

    public Ticket park(Car car) {
        boolean isCarIn = parkingLots.stream()
                .map(parkingLot -> parkingLot.checkContainsCar(car))
                .findFirst()
                .orElse(false);

        if (isCarIn) {
            return null;
        }

        return parkingLots.stream()
                .map(parkingLot -> parkingLot.park(car))
                .filter(Objects::nonNull)
                .findFirst()
                .orElse(null);
    }

    public Car pick(Ticket ticket) {
        return parkingLots.stream()
                .map(parkingLot -> parkingLot.pick(ticket))
                .filter(Objects::nonNull)
                .findFirst()
                .orElse(null);
    }

}
