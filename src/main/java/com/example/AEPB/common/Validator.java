package com.example.AEPB.common;

import com.example.AEPB.domain.Car;
import com.example.AEPB.domain.Ticket;
import org.springframework.util.StringUtils;

import java.util.Objects;

public class Validator {

    public static boolean validateCar(Car car) {
        return Objects.nonNull(car) && StringUtils.hasText(car.getPlateNum());
    }

    public static boolean validateTicket(Ticket ticket) {
        return Objects.nonNull(ticket) && StringUtils.hasText(ticket.getCarPlateNum());
    }

}