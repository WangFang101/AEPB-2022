package com.example.AEPB.common;

import com.example.AEPB.domain.ParkingLot;

import java.util.List;

public interface ParkingLotStrategy {

    ParkingLot choose(List<ParkingLot> parkingLotList);

}
