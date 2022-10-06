package Repositories;

import Entities.SystemOfTasks;
import Infrastructure.IEmployee;
import Infrastructure.ISystemRep;
import Infrastructure.ITask;

public class SystemRep implements ISystemRep<SystemOfTasks> {
    SystemOfTasks systemOfTasks = new SystemOfTasks();


    @Override
    public void addTask(ITask task) {

    }

    @Override
    public void removeTask(ITask task) {

    }

    @Override
    public void setEmp(IEmployee employee, ITask task) {

    }
}
