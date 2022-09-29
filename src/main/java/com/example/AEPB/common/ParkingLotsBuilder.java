package com.example.AEPB.common;

import com.example.AEPB.domain.ParkingLot;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParkingLotsBuilder {

    private static final int DEFAULT_COUNT = 3;

    public static List<ParkingLot> buildParkingLots(int capacity) {
        return IntStream.range(0, DEFAULT_COUNT)
                .mapToObj(i -> new ParkingLot(capacity))
                .collect(Collectors.toList());
    }

}
