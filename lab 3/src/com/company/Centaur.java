package com.company;

public class Centaur extends LandTransport {
    Centaur() {
        super(15.0d, "Centaur", 8.0d);
    }

    @Override
    double racingForLand(double distance, double[] someArray) {
        someArray[0] = 2.0d;
        return super.racingForLand(distance, someArray);
    }
}