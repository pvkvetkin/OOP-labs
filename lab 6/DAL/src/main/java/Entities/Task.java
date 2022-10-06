package Entities;

import Infrastructure.IEmployee;
import Infrastructure.ITask;
import Infrastructure.State;

import java.util.ArrayList;

public class Task implements ITask {
    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public IEmployee getEmployee() {
        return employee;
    }

    @Override
    public void setEmployee(IEmployee employee) {
        this.employee = employee;
    }

    @Override
    public State getState() {
        return state;
    }

    @Override
    public void setState(State state) {
        this.state = state;
    }

    @Override
    public ArrayList<String> getComments() {
        return comments;
    }

    @Override
    public void setComments(ArrayList<String> comments) {
        this.comments = comments;
    }

    String name;
    String description;
    IEmployee employee;
    State state;
    ArrayList<String> comments = new ArrayList<String>();
}
