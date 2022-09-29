package com.example.AEPB.common;

import com.example.AEPB.domain.Car;
import com.example.AEPB.domain.ParkingLot;
import com.example.AEPB.domain.Ticket;

import java.util.List;
import java.util.Objects;

public class ParkTemplate {

    public Ticket park(List<ParkingLot> parkingLotList, Car car, ParkingLotStrategy strategy) {
        if (!Validator.validateCar(car)) {
            return null;
        }

        if (isCarIn(parkingLotList, car)) {
            return null;
        }

        ParkingLot parkingLot = strategy.choose(parkingLotList);
        if (Objects.isNull(parkingLot)) {
            return null;
        }

        return parkingLot.park(car);
    }

    private boolean isCarIn(List<ParkingLot> parkingLotList, Car car) {
        return parkingLotList.stream()
                .anyMatch(parkingLot -> parkingLot.containsCar(car));
    }

}
