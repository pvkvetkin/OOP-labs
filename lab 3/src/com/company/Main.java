package com.company;

public class Main {

    public static void main(String[] args) {
        try {
            System.out.println("++++++++++++++++++++++++++++++Land transport++++++++++++++++++++++++++++++");
            LandTransportsRace landTransportsRace = new LandTransportsRace(11000.0d);
            Centaur centaur = new Centaur();
            landTransportsRace.register(centaur, landTransportsRace);
            BactrianCamel bactrianCamel = new BactrianCamel();
            landTransportsRace.register(bactrianCamel, landTransportsRace);
            SpeedCamel speedCamel = new SpeedCamel();
            landTransportsRace.register(speedCamel, landTransportsRace);
            System.out.println("The winner is " + landTransportsRace.getNameTransport());
        } catch (Exception error) {
            System.err.println(error.getMessage());
        }
        try {
            System.out.println("++++++++++++++++++++++++++++++Air transports++++++++++++++++++++++++++++++");
            AirTransportsRace airTransportsRace = new AirTransportsRace(11000.0d);
            Broom broom = new Broom();
            airTransportsRace.register(broom, airTransportsRace);
            MagicCarpet magicCarpet = new MagicCarpet();
            airTransportsRace.register(magicCarpet, airTransportsRace);
            Mortar mortar = new Mortar();
            airTransportsRace.register(mortar, airTransportsRace);
            System.out.println("The winner is " + airTransportsRace.getNameTransport());
        } catch (Exception error) {
            System.err.println(error.getMessage());
        }
        try {
            System.out.println("++++++++++++++++++++++++++++++Both transports++++++++++++++++++++++++++++++");
            BothTransportsRace bothTransportsRace = new BothTransportsRace(11000.0d);
            Centaur centaur = new Centaur();
            bothTransportsRace.register(centaur, bothTransportsRace);
            Broom broom = new Broom();
            bothTransportsRace.register(broom, bothTransportsRace);
            BactrianCamel bactrianCamel = new BactrianCamel();
            bothTransportsRace.register(bactrianCamel, bothTransportsRace);
            System.out.println("The winner is " + bothTransportsRace.getNameTransport());
        } catch (Exception error) {
            System.err.println(error.getMessage());
        }
    }
}