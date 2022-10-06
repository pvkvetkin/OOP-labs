package com.company;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Bank {
    private Map<Integer, Account> accounts = new HashMap<>();
    private int incr = -1;
    private double cashbackPercent;
    private double commisionPercent;



    Bank (double cashbackPercent, double commisionPercent) {
        this.cashbackPercent = cashbackPercent;
        this.commisionPercent = commisionPercent;
    }

    public void checkOnPercent(int index) {
        if (accounts.get(index).getType() == TYPEACCOUNT.DEPOSIT) {

        }
    }

    public double getMoney(int index) {
        return accounts.get(index).getMoney();
    }

    public void addAccount(Account someAccount) {
        incr++;
        accounts.put(incr, someAccount);
    }

    public void withdraw(int index, double amountSum) {
        accounts.get(index).withdraw(amountSum);
    }

    public void topUp(int index, double amountSum) {
        accounts.get(index).topUp(amountSum);
    }

    public void transfer(int index, int toIndex, double amountSum) {
        accounts.get(index).transfer(toIndex, amountSum);
    }

    public void cancelOperation(int indexOfAccount, int indexOfOperation) {
        accounts.get(indexOfAccount).getIdSum(indexOfAccount);
    }
}
