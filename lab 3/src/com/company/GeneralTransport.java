package com.company;

public abstract class GeneralTransport {
    protected double speed;
    protected String name;
    protected double restInterval;
    protected double restDuration;
    GeneralTransport(double speed_, String name_) {
        if (speed_ < 0.0d) {
            throw new RuntimeException("Value of speed is wrong");
        }
        speed = speed_;
        name = name_;
    }

    double racingForAir(double distance, double coefficient) {
        double finalDistance = (distance - (distance * ((coefficient / 1000.0d) / 100.0d))) / speed;
        return finalDistance;
    }

    double racingForLand(double distance, double[] someArray) {
        restDuration = someArray[0];
        double time = 0.0d;
        double secondDistance = 0.0d;
        boolean flag = false;
        int increment = -1;
        while (secondDistance < distance) {
            if (!flag) {
                secondDistance += speed * restInterval;
                time += restInterval;
                flag = true;
                if (increment == 0  && someArray[1] != -1.0d) {
                    increment++;
                    restDuration = someArray[1];
                    continue;
                } else if (increment == 1 && someArray[2] != -1.0d) {
                    increment++;
                    restDuration = someArray[2];
                    continue;
                }
                increment++;
            } else {
                time += restDuration;
                flag = false;
            }
        }
        return time;
    }

    String getName() {
        return name;
    }
}