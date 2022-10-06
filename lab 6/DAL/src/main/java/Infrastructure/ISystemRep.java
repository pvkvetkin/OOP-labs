package Infrastructure;

public interface ISystemRep <SystemOfTasks> {
    void addTask(ITask task);

    void removeTask(ITask task);

    void setEmp(IEmployee employee, ITask task);


}
