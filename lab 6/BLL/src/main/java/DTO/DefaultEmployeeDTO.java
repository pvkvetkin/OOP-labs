package DTO;

import Infrastructure.IEmployee;
import Infrastructure.Roles;

import java.util.ArrayList;

public class DefaultEmployeeDTO implements IEmployee {
    String name;
    IEmployee lead;
    Roles role = Roles.DEFAULT;
    ArrayList<IEmployee> employees = new ArrayList<IEmployee>();

    public DefaultEmployeeDTO(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLead(IEmployee lead) {
        this.lead = lead;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public void setEmployees(ArrayList<IEmployee> employees) {
        this.employees = employees;
    }

    public IEmployee getLead() {
        return lead;
    }

    public Roles getRole() {
        return role;
    }

    public ArrayList<IEmployee> getEmployees() {
        return employees;
    }

    public String getName() {
        return name;
    }
}
