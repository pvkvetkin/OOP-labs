package com.company;

import java.util.HashMap;
import java.util.Map;

public class EcosystemOfBackups {
    private int incr = -1;
    private Map<Integer, Backup> backups = new HashMap<>();

    public void put(Backup backup) {
        incr++;
        backups.put(incr, backup);
    }

    public void addInBackup(int index, IPoint point) {
        backups.get(index).addPoint(point);
    }

    public int getSize() {
        return backups.size();
    }

    public void printBackup(int index) {
        backups.get(index).printPoints();
    }
}
