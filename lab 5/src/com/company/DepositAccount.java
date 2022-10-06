package com.company;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class DepositAccount implements Account {
    private Client client;
    private LocalDate start;
    private double cashbackPercent;
    private double commisionPercent;
    private boolean flag;
    private LocalDate limit;
    private double money;
    private double cashback;
    private TYPEACCOUNT type = TYPEACCOUNT.DEPOSIT;
    Map<Integer, Double> idSum = new HashMap<>();
    int incr = -1;

    public DepositAccount(Client client, LocalDate localDate) {
        this.client = new Client(client);
        money = 0;
        limit = localDate;
        if (this.client.getAddress() != "" || this.client.getPasportsNumber() != -1) {
            flag = true;
        }
    }

    public DepositAccount(int cashbackPercent, LocalDate limit) {
        this.cashbackPercent = cashbackPercent;
        this.limit = limit;
        commisionPercent = 0;
        flag = false;
        start = new Time().timeNow();
    }

    public DepositAccount(int cashbackPercent) {
        this.cashbackPercent = 0;
        commisionPercent = 0;
        flag = true;
    }

    public void getIdSum(int id) {
        money += idSum.get(id + 1);
    }

    @Override
    public double getMoney() {
        return money;
    }

    public void setCashbackPercent(int cashbackPercent) {
        this.cashbackPercent = cashbackPercent;
    }

    public double getCashbackPercent() {
        return cashbackPercent;
    }

    public void setCommisionPercent(int commisionPercent) {
        this.commisionPercent = commisionPercent;
    }

    public double getCommisionPercent() {
        return commisionPercent;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public boolean getFlag () {
        return flag;
    }

    public LocalDate getLimit() {
        return limit;
    }

    public void setLimit(LocalDate limit) {
        this.limit = limit;
        flag = false;
    }

    public void checkOnLimit () {
            if (new Time().timeNow().isAfter(limit)) {
                flag = true;
            } else {
                flag = false;
            }
    }

    @Override
    public OPERATION withdraw(double requestedAmount) {
        checkOnLimit();
            if (flag) {
                if (money >= requestedAmount) {
                    incr++;
                    idSum.put(incr, money);
                    money -= requestedAmount;
                    System.out.println(OPERATION.SUCCESSFULLY);
                    return OPERATION.SUCCESSFULLY;
                } else {
                    System.out.println(OPERATION.NOT_SUCCESSFUL);
                    return OPERATION.NOT_SUCCESSFUL;
                }
            } else {
                System.out.println(OPERATION.NOT_SUCCESSFUL);
                return OPERATION.NOT_SUCCESSFUL;
            }
    }

    @Override
    public OPERATION topUp(double requestedAmount) {
        incr++;
        idSum.put(incr, money);
        money += requestedAmount;
        System.out.println(OPERATION.SUCCESSFULLY);
        return OPERATION.SUCCESSFULLY;
    }

    @Override
    public OPERATION transfer(int id, double requestedAmount) {
        checkOnLimit();
        if (flag) {
            if (money >= requestedAmount) {
                incr++;
                idSum.put(incr, money);
                money -= requestedAmount;
                System.out.println(OPERATION.SUCCESSFULLY);
                return OPERATION.SUCCESSFULLY;
            } else {
                System.out.println(OPERATION.NOT_SUCCESSFUL);
                return OPERATION.NOT_SUCCESSFUL;
            }
        } else {
            System.out.println(OPERATION.NOT_SUCCESSFUL);
            return OPERATION.NOT_SUCCESSFUL;
        }
    }

    @Override
    public TYPEACCOUNT getType() {
        return type;
    }
}

