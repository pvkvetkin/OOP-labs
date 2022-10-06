package com.company;

import javafx.util.Pair;

import java.util.Comparator;
import java.util.PriorityQueue;

public abstract class Race {
    protected double distance;

    Race(double distance_) {
        if (distance_ < 0.0d) {
            throw new RuntimeException("Value of distance is wrong");
        }
        distance = distance_;
    }

    protected PriorityQueue<Pair<String, Double>> members =
            new PriorityQueue<Pair<String, Double>>(Comparator.comparing(Pair::getValue));


    public void register(GeneralTransport object, Race race) {
        if (race instanceof BothTransportsRace) {
            if(object instanceof AirTransport) {
                members.add(new Pair<>(object.getName(), object.racingForAir(distance, 0.0d)));
            } else if (object instanceof LandTransport) {
                members.add(new Pair<>(object.getName(), object.racingForLand(distance, new double[]
                        {-1.0d, -1.0d, -1.0d})));
            }
        } else if(race instanceof LandTransportsRace) {
            members.add(new Pair<>(object.getName(), object.racingForLand(distance, new double[]
                    {-1.0d, -1.0d, -1.0d})));
        } else if(race instanceof AirTransportsRace) {
            members.add(new Pair<>(object.getName(), object.racingForAir(distance, 0.0d)));
        } else {
            throw new RuntimeException("Wrong transport in race");
        }
    }

    public String getNameTransport () {
        if (members.isEmpty()) {
            throw new RuntimeException("Race is not fount members");
        }
        return members.peek().getKey();
    }

    public Double getTimeTransport () {
        if (members.isEmpty()) {
            throw new RuntimeException("Race is not fount members");
        }
        return members.peek().getValue();
    }
}