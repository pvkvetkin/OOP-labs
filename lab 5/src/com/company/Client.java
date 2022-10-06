package com.company;

public class Client {
    private String name;
    private String surname;
    private String address = "";
    private int pasportsNumber = -1;

    Client (String name, String surname, String address, int pasportsNumber) {
       this.name = name;
       this.surname = surname;
       this.address = address;
       this.pasportsNumber = pasportsNumber;
    }

    public Client(Client client) {
        this.name = client.name;
        this.surname = client.surname;
        this.address = client.address;
        this.pasportsNumber = client.pasportsNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPasportsNumber(int pasportsNumber) {
        this.pasportsNumber = pasportsNumber;
    }

    public String getSurname() {
        return surname;
    }

    public String getAddress() {
        return address;
    }

    public int getPasportsNumber() {
        return pasportsNumber;
    }

    public void print() {
        System.out.print(name + " " + surname + " ");
        if (!address.equals("")) {
            System.out.print(address + " ");
        }  if (pasportsNumber != -1) {
            System.out.print(pasportsNumber);
        }
        System.out.println();
    }
}
