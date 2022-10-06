package com.company;

class ManualClient implements IClientBuilder {
    private String name;
    private String surname;
    private String address = "";
    private int pasportsNumber = -1;


    @Override
    public IClientBuilder setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public IClientBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    @Override
    public IClientBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    @Override
    public IClientBuilder setPasportsNumber(int pasportsNumber) {
        this.pasportsNumber = pasportsNumber;
        return this;
    }

    public Client Build() {
        return new Client(name, surname, address, pasportsNumber);
    }
}
