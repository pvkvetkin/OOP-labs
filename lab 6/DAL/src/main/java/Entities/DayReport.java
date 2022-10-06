package Entities;

import Infrastructure.IEmployee;
import Infrastructure.IReport;
import Infrastructure.ITask;

import java.util.Map;

public class DayReport implements IReport {
    @Override
    public void setReports(Map<ITask, IEmployee> reports) {

    }

    @Override
    public Map<ITask, IEmployee> getReports() {
        return null;
    }

    @Override
    public void setFlag(boolean flag) {

    }

    @Override
    public boolean getFlag() {
        return false;
    }
}
