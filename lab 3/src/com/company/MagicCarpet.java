package com.company;

public class MagicCarpet extends AirTransport{
    MagicCarpet() {
        super(10.0d, "Magic carpet");
    }

    @Override
    double racingForAir(double distance, double coefficient) {
        if (distance < 1000.0d) {
            coefficient = 100.0d;
        } else if (distance < 5000.0d) {
            coefficient = 3.0d;
        } else if (distance < 10000.0d) {
            coefficient = 10.0d;
        } else {
            coefficient = 5.0d;
        }
        return super.racingForAir(distance, coefficient);
    }
}
