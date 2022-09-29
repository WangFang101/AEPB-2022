package com.example.AEPB.common;

import com.example.AEPB.domain.Car;
import com.example.AEPB.domain.ParkingLot;
import com.example.AEPB.domain.Ticket;

import java.util.List;
import java.util.Objects;

public class PickTemplate {

    public Car pick(List<ParkingLot> parkingLotList, Ticket ticket) {
        if (!Validator.validateTicket(ticket)) {
            return null;
        }

        return parkingLotList.stream()
                .map(parkingLot -> parkingLot.pick(ticket))
                .filter(Objects::nonNull)
                .findFirst()
                .orElse(null);
    }

}
