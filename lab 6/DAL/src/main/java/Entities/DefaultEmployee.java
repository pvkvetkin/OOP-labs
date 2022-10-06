package Entities;

import Infrastructure.IEmployee;
import Infrastructure.Roles;

import java.util.ArrayList;

public class DefaultEmployee implements IEmployee {
    String name;
    IEmployee lead;
    Roles role = Roles.DEFAULT;
    ArrayList<IEmployee> employees = new ArrayList<>();

    public DefaultEmployee(String name) {
        this.name = name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setLead(IEmployee lead) {
        this.lead = lead;
    }

    @Override
    public void setRole(Roles role) {
        this.role = role;
    }

    @Override
    public void setEmployees(ArrayList<IEmployee> employees) {
        this.employees = employees;
    }

    @Override
    public IEmployee getLead() {
        return lead;
    }

    @Override
    public Roles getRole() {
        return role;
    }

    @Override
    public ArrayList<IEmployee> getEmployees() {
        return employees;
    }

    @Override
    public String getName() {
        return name;
    }
}
