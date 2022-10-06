package com.company;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

enum DATE{
    SECONDS,
    MINUTES,
    HOURS,
    DAYS,
    MONTHS,
    YEARS,
    NOW
}

class Time{
    private int plus = 0;

    public LocalDate timeNow(DATE format, int number) {
        switch (format) {
            case DAYS -> {
                plus += number;
                return LocalDate.now().plusDays(plus);
            } case MONTHS -> {
                plus += 30 * number;
                return LocalDate.now().plusMonths(plus);
            } case YEARS -> {
                plus += 365 * number;
                return LocalDate.now().plusYears(plus);
            } default -> {
                throw new RuntimeException("Wrong format of date");
            }
        }
    }

    public LocalDate timeInFuture(DATE format, int number) {
        switch (format) {
            case DAYS -> {
                plus += number;
                return LocalDate.now().plusDays(number);
            } case MONTHS -> {
                plus += 30 * number;
                return LocalDate.now().plusMonths(number);
            } case YEARS -> {
                plus += 365 * number;
                return LocalDate.now().plusYears(number);
            } default -> {
                throw new RuntimeException("Wrong format of date");
            }
        }
    }

    public LocalDate timeNow() {
        return LocalDate.now().plusDays(plus);
    }
}

public class Main {

    public static void main(String[] args) {
//        System.out.println(LocalDate.now());
//        System.out.println(new Time().timeNow(DATE.DAYS, 5));
//        System.out.println(LocalDate.now().getDayOfMonth());
        ManualClient defaultClient = new ManualClient();
        Client client1 =  defaultClient.setName("A").setSurname("B").setAddress("AB").setPasportsNumber(10).Build();
        Client client2 = defaultClient.setName("C").setSurname("D").setAddress("CD").setPasportsNumber(101).Build();
        Client client3 = defaultClient.setName("E").setSurname("F").setAddress("EF").setPasportsNumber(10000).Build();
        Bank bank = new Bank(3.65, 3.65);
        bank.addAccount(new DepositAccount(client1, new Time().timeInFuture(DATE.DAYS, 7)));
        bank.addAccount(new CreditAccount(client2));
        bank.topUp(0, 5000.0d);
        System.out.println(bank.getMoney(0));
//        Map<Integer, Integer> banks = new HashMap<>();
//        banks.put(1, 1);
//        banks.put(2, 12);
//        banks.put(3, 1);
//        System.out.println(banks.get(2));
//        for (Map.Entry<Integer, Integer> item : banks.entrySet()) {
//            System.out.println(item.getKey());
//            System.out.println(item.getValue());
//        }
    }
}
