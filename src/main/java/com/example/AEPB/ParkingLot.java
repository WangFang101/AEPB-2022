package com.example.AEPB;

import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashSet;
import java.util.Set;

public class ParkingLot {

    private int size;
    private Set<String> carPlateNums = new HashSet<>();

    public ParkingLot(int size) {
        this.size = size;
    }

    public Ticket park(Car car) {
        if (size == carPlateNums.size()) {
            return null;
        }

        String carPlateNum = car.getPlateNum();

        if (!StringUtils.hasText(carPlateNum)) {
            return null;
        }

        if (carPlateNums.add(carPlateNum)) {
            return new Ticket(carPlateNum);
        }

        return null;
    }

    public Car pick(Ticket ticket) {
        String carPlateNum = ticket.getCarPlateNum();

        if (!StringUtils.hasText(carPlateNum)) {
            return null;
        }

        if (carPlateNums.remove(carPlateNum)) {
            return new Car(carPlateNum);
        }

        return null;
    }

    public boolean checkContainsCar(Car car) {
        String carPlateNum = car.getPlateNum();
        if (!StringUtils.hasText(carPlateNum)) {
            return false;
        }

        return carPlateNums.contains(carPlateNum);
    }

    public int getPlotLeftCapacity() {

        return  size - carPlateNums.size();
    }

    public BigDecimal calVacancyRate() {
        return new BigDecimal(getPlotLeftCapacity()).divide(new BigDecimal(size), RoundingMode.HALF_UP);
    }

}
