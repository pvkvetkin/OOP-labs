package Infrastructure;

import java.util.ArrayList;
import java.util.Map;

public interface IEmployeeRep <IEmployee> {
    Map<Integer, IEmployee> getAll();

    IEmployee getEmp(int id);

    void addEmp(IEmployee employee);

    void removeEmp(int id);
}
