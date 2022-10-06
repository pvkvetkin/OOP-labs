package com.company;

public class Broom extends AirTransport {
    Broom() {
        super(20.0d, "Broom");
    }

    @Override
    double racingForAir(double distance, double coefficent) {
        coefficent = distance;
        return super.racingForAir(distance, coefficent);
    }
}
