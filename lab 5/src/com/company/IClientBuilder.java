package com.company;

public interface IClientBuilder {
    public IClientBuilder setName(String name_);

    public IClientBuilder setSurname(String surname_);

    public IClientBuilder setAddress(String address_);

    public IClientBuilder setPasportsNumber(int pasportsNumber_);

    public Client Build();
}
