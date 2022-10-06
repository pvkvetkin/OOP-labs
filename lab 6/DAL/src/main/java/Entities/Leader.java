package Entities;

import Infrastructure.IEmployee;
import Infrastructure.Roles;

import java.util.ArrayList;

public class Leader implements IEmployee {
    @Override
    public void setName(String name) {

    }

    @Override
    public void setLead(IEmployee lead) {

    }

    @Override
    public void setRole(Roles role) {

    }

    @Override
    public void setEmployees(ArrayList<IEmployee> employees) {

    }

    @Override
    public IEmployee getLead() {
        return null;
    }

    @Override
    public Roles getRole() {
        return null;
    }

    @Override
    public ArrayList<IEmployee> getEmployees() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }
}
