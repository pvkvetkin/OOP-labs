package Infrastructure;

import java.util.ArrayList;

public interface ITask {
    void setName(String name);

    void setDescription(String description);

    void setEmployee(IEmployee someEmp);

    void setState(State state);

    void setComments(ArrayList<String> comments);

    String getName();

    String getDescription();

    IEmployee getEmployee();

    State getState();

    ArrayList<String> getComments();
}
