package Entities;

import Infrastructure.IEmployee;
import javafx.util.Pair;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SystemOfTasks {
    Map<Task, ArrayList<Pair<String, LocalDateTime>>> system = new HashMap<>();

    void addTask(Task task) {
        system.get(task).add
                (new Pair<String, LocalDateTime>("Task created", LocalDateTime.now()));
    }

    void addComment(IEmployee employee, String comment) {
        for(Map.Entry<Task, ArrayList<Pair<String, LocalDateTime>>> i : system.entrySet()) {
            if(i.getKey().getEmployee() == employee) {
                system.get(i.getKey()).add
                        (new Pair<String, LocalDateTime>("Comment: " + comment, LocalDateTime.now()));
                break;
            }
        }
    }
}
