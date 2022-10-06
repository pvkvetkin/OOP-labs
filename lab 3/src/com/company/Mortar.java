package com.company;

public class Mortar extends  AirTransport {
    Mortar() {
        super(8.0d, "Mortar");
    }

    @Override
    double racingForAir(double distance, double coefficient) {
        coefficient = 6.0d;
        return super.racingForAir(distance, coefficient);
    }
}
