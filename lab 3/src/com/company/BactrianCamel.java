package com.company;

public class BactrianCamel extends LandTransport {
    BactrianCamel () {
        super (10.0d, "Bactrian Camel", 30.0d);
    }

    @Override
    double racingForLand(double distance, double[] someArray) {
        someArray[0] = 5.0d;
        someArray[1] = 8.0d;
        return super.racingForLand(distance, someArray);
    }
}
