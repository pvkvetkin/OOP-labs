package Infrastructure;

import java.util.ArrayList;

public interface IEmployee {
    void setName(String name);

    void setLead(IEmployee lead);

    void setRole(Roles role);

    void setEmployees(ArrayList<IEmployee> employees);

    IEmployee getLead();

    Roles getRole();

    ArrayList<IEmployee> getEmployees();

    String getName();
}
