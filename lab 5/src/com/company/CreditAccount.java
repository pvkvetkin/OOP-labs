package com.company;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class CreditAccount implements Account {
    private Client client;
    private double commisionPercent;
    private double limitSum;
    private boolean flag = true;
    private double money;
    private TYPEACCOUNT type = TYPEACCOUNT.CREDIT;
    Map<Integer, Double> idSum = new HashMap<>();
    int incr = -1;

    public CreditAccount(Client client) {
        this.client = new Client(client);
        if (this.client.getAddress() != "" || this.client.getPasportsNumber() != -1) {
            flag = true;
        }
    }

    public CreditAccount(int limitSum) {
        this.limitSum = limitSum;
        commisionPercent = 0;
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
            if (requestedAmount <= money && limitSum > (money - requestedAmount)) {
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
        if (requestedAmount > 0) {
            incr++;
            idSum.put(incr, money);
            money += requestedAmount;
            System.out.println(OPERATION.SUCCESSFULLY);
            return OPERATION.SUCCESSFULLY;
        } else {
            System.out.println(OPERATION.NOT_SUCCESSFUL);
            return OPERATION.NOT_SUCCESSFUL;
        }
    }

    @Override
    public OPERATION transfer(int id, double requestedAmount) {
        if (requestedAmount > 0) {
            if (requestedAmount >= money) {
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
