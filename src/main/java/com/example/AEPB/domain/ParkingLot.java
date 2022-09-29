package com.example.AEPB.domain;

import com.example.AEPB.common.Validator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashSet;
import java.util.Set;

public class ParkingLot {

    private int capacity;
    private Set<String> carPlateNums = new HashSet<>();

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public Ticket park(Car car) {
        if (!isNotFull()) {
            return null;
        }

        if (!Validator.validateCar(car)) {
            return null;
        }

        String carPlateNum = car.getPlateNum();
        if (carPlateNums.add(carPlateNum)) {
            return new Ticket(carPlateNum);
        }

        return null;
    }

    public Car pick(Ticket ticket) {
        if (!Validator.validateTicket(ticket)) {
            return null;
        }

        String carPlateNum = ticket.getCarPlateNum();
        if (carPlateNums.remove(carPlateNum)) {
            return new Car(carPlateNum);
        }

        return null;
    }

    public boolean containsCar(Car car) {
        if (!Validator.validateCar(car)) {
            return false;
        }

        return carPlateNums.contains(car.getPlateNum());
    }

    public int getLeftCapacity() {
        return  capacity - carPlateNums.size();
    }

    public BigDecimal calVacancyRate() {
        return new BigDecimal(getLeftCapacity()).divide(new BigDecimal(capacity), 2, RoundingMode.HALF_UP);
    }

    public boolean isNotFull() {
        return getLeftCapacity() > 0;
    }

}
