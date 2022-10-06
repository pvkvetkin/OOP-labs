package com.company;

enum DATE{
    MINUTES,
    HOURS,
    DAYS,
    MONTHS,
    YEARS
}

public class TimeChanger {
    private int numberOfMinutesInFuture = 0;

    public int getNumberOfMinutes(DATE date, int number) {
        if (number < 0) {
            throw new RuntimeException("Negative number of time");
        }
        switch (date) {
            case MINUTES -> {
                numberOfMinutesInFuture += number;
            }
            case HOURS -> {
                numberOfMinutesInFuture += 60 * number;
            }
            case DAYS -> {
                numberOfMinutesInFuture += 1440 * number;
            }
            case MONTHS -> {
                numberOfMinutesInFuture += 34200 * number;
            }
            case YEARS -> {
                numberOfMinutesInFuture += 410400 * number;
            }
            default -> {
                throw new RuntimeException("Wrong format of date");
            }
        }
        return numberOfMinutesInFuture;
    }

    public int getNumberOfMinutes() {
        return numberOfMinutesInFuture;
    }
}
