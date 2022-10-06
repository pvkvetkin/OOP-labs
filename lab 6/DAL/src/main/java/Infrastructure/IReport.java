package Infrastructure;

import java.util.Map;

public interface IReport {
    void setReports(Map<ITask, IEmployee> reports);

    Map<ITask, IEmployee> getReports();

    void setFlag(boolean flag);

    boolean getFlag();
}
