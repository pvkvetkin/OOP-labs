package com.company;

enum TYPEACCOUNT{
    DEBIT,
    DEPOSIT,
    CREDIT
}

enum OPERATION{
    SUCCESSFULLY,
    NOT_SUCCESSFUL
}

public interface Account {
    OPERATION withdraw(double requestedAmount);

    OPERATION topUp(double requestedAmount);

    OPERATION transfer(int id, double requestedAmount);

    TYPEACCOUNT getType();

    void getIdSum(int id);

    double getMoney();
}
