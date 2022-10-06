package com.company;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DebitAccount implements Account {
    private Client client;
    private LocalDate start;
    private double cashbackPercent;
    private double commisionPercent;
    private double money;
    private boolean flag;
    private TYPEACCOUNT type = TYPEACCOUNT.DEBIT;
    Map<Integer, Double> idSum = new HashMap<>();
    int incr = -1;

    public DebitAccount(Client client) {
        this.client = new Client(client);
        if (this.client.getAddress() != "" || this.client.getPasportsNumber() != -1) {
            flag = true;
        }
    }

    public DebitAccount(int cashbackPercent) {
        this.cashbackPercent = cashbackPercent;
        commisionPercent = 0;
        flag = true;
        start = new Time().timeNow();
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

    public void getIdSum(int id) {
        money += idSum.get(id + 1);
    }

    @Override
    public double getMoney() {
        return money;
    }


    @Override
    public OPERATION withdraw(double requestedAmount) {
        if (requestedAmount > 0) {
            if (money >= requestedAmount) {
                incr++;
                idSum.put(incr, money);
                money -= requestedAmount;
                System.out.println(OPERATION.SUCCESSFULLY);
                return OPERATION.SUCCESSFULLY;
            } else {
                return OPERATION.NOT_SUCCESSFUL;
            }
        } else {
            return OPERATION.NOT_SUCCESSFUL;
        }
    }

    @Override
    public OPERATION topUp(double requestedAmount) {
        if (requestedAmount > 0) {
            incr++;
            idSum.put(incr, money);
            money += requestedAmount;
            System.out.println(OPERATION.SUCCESSFULLY);
            return OPERATION.SUCCESSFULLY;
        } else {
            return OPERATION.NOT_SUCCESSFUL;
        }
    }

    @Override
    public OPERATION transfer(int id, double requestedAmount) {
        if (requestedAmount > 0) {
            if (money >= requestedAmount) {
                incr++;
                idSum.put(incr, money);
                money -= requestedAmount;
                System.out.println(OPERATION.SUCCESSFULLY);
                return OPERATION.SUCCESSFULLY;
            } else {
                return OPERATION.NOT_SUCCESSFUL;
            }
        } else {
            return OPERATION.NOT_SUCCESSFUL;
        }
    }

    @Override
    public TYPEACCOUNT getType() {
        return type;
    }
}
