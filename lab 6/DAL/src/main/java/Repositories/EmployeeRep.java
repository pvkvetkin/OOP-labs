package Repositories;

import Infrastructure.IEmployee;
import Infrastructure.IEmployeeRep;

import java.util.HashMap;
import java.util.Map;

public class EmployeeRep <IEmployee> implements IEmployeeRep<IEmployee> {
    Map<Integer, IEmployee> employees= new HashMap<>();

    @Override
    public Map<Integer, IEmployee> getAll() {
        return employees;
    }

    @Override
    public IEmployee getEmp(int id) {
        return employees.get(id);
    }

    @Override
    public void addEmp(IEmployee employee) {
        employees.put(employees.size(), employee);
    }

    @Override
    public void removeEmp(int id) {
        employees.remove(id);
    }
}
