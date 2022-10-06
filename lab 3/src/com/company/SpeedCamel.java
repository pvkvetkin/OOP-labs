package com.company;

public class SpeedCamel extends LandTransport{
    SpeedCamel () {
        super (40.0d, "Speed Camel", 10.0d);
    }

    @Override
    double racingForLand(double distance, double[] someArray) {
        someArray[0] = 5.0d;
        someArray[1] = 6.5d;
        someArray[2] = 8.0d;
        return super.racingForLand(distance, someArray);
    }
}
