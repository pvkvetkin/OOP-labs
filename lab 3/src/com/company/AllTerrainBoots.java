package com.company;

public class AllTerrainBoots extends LandTransport {
    AllTerrainBoots () {
        super (6.0d, "All-terrain boots", 60.0d);
    }

    @Override
    double racingForLand(double distance, double[] someArray) {
        someArray[0] = 10.0d;
        someArray[1] = 5.0d;
        return super.racingForLand(distance, someArray);
    }
}
