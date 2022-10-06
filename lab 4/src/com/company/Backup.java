package com.company;

import javafx.util.Pair;

import java.time.LocalDateTime;
import java.util.ArrayList;

enum Hybryd{
    COUNT,
    DATE,
    SIZE,
}

enum MinMax{
    MIN,
    MAX
}

public class Backup {
    private LocalDateTime creationTime;
    private int backupSize;
    private ArrayList<IPoint> listOfPoints = new ArrayList<IPoint>();
    private int index = -1;

    Backup(int numberOfMinutes) {
        backupSize = 0;
        creationTime = LocalDateTime.now().plusMinutes(numberOfMinutes);
    }

    public void addPoint(IPoint pointOfBackup) {
        listOfPoints.add(pointOfBackup);
        backupSize = pointOfBackup.getSizeOfFiles();
        index++;
    }

    public int getIndex() {
        return index;
    }

    public boolean checkOnAbilityRemove(int indexElement) {
        if (listOfPoints.get(0).getTypeOfPoint() == InfoPoint.FULL) {
            for (int i = indexElement; i >= 0; --i) {
                if (listOfPoints.get(i).getTypeOfPoint() == InfoPoint.INCREMENTAL) {
                    if (listOfPoints.get(i + 1).getTypeOfPoint() == InfoPoint.INCREMENTAL) {
                        return false;
                    } else if (listOfPoints.get(i + 1).getTypeOfPoint() == InfoPoint.FULL) {
                        return true;
                    }
                } else {
                    return false;
                }
            }
        } else {
            return false;
        }
    return true;
    }

    public void removeCount(int number) {
        number -= 1;
        int buf = 0;
        boolean flag = false;
            for (int i = number; i > 0; --i) {
                if (checkOnAbilityRemove(i)) {
                    buf = i;
                    flag = true;
                    break;
                }
            }
            if (!checkOnAbilityRemove(number)) {
                System.out.println("Operation of remove on count doesn't remove all requested points");
            }
        if (flag) {
            for(int i = 0; i <= buf; ++i) {
                listOfPoints.remove(0);
            }
        }
    }

    public void removeDate(int seconds) {
        LocalDateTime someDate = LocalDateTime.now().minusSeconds(seconds);
        if (listOfPoints.get(0).getTypeOfPoint() == InfoPoint.FULL) {
            for (int i = listOfPoints.size() - 1; i >= 0; --i) {
                if (listOfPoints.get(i).getCreationTime().isBefore(someDate)) {
                    if (checkOnAbilityRemove(i)) {
                        if (!checkOnAbilityRemove(listOfPoints.size() - 1)) {
                            System.out.println("Operation of remove on date doesn't remove all requested points");
                        }
                        for (int j = 0; j <= i; ++j) {
                            listOfPoints.remove(0);
                        }
                        break;
                    }
                    break;
                }
            }
        } else {
            throw new RuntimeException("Incremential point doesn't have full point");
        }
    }

    public void removeSize(int backupSize_) {
        int buffer_ = 0;
        int index_ = listOfPoints.size() - 1;
        for(int i = listOfPoints.size() - 1; i >= 0; --i) {
            buffer_ += listOfPoints.get(i).getSizeOfFiles();
            if (buffer_ < backupSize_) {
                index_--;
            } else {
                break;
            }
        }
        for(int i = 0; i <= index_; ++i) {
            listOfPoints.remove(0);
        }
        index_ = listOfPoints.size() - 1;
        int someIndex = index;
        if (!checkOnAbilityRemove(someIndex)) {
            System.out.println("Operation of remove on size doesn't remove all requested points");
        }
        while (true) {
            if (!checkOnAbilityRemove(index_)) {
                listOfPoints.remove(0);
                index_--;
                if (index_ == 0) {
                    break;
                }
            } else {
                break;
            }
        }
    }

    public void removeHybryd(ArrayList<Pair<Hybryd, Integer>> listOfParameters, MinMax minOrMax) {
        int currentCount = 0;
        int buffer;
        Pair<Hybryd, Integer>  operation = null;
        if (minOrMax == MinMax.MAX) {
            buffer = -1;
        } else {
            buffer = Integer.MAX_VALUE;
        }
        ArrayList<IPoint> copyPoints = new ArrayList<>(listOfPoints);
        for(int i = 0; i < listOfParameters.size(); ++i) {
            switch(listOfParameters.get(i).getKey()) {
                case COUNT -> {
                    removeCount(listOfParameters.get(i).getValue());
                } case DATE -> {
                    removeDate(listOfParameters.get(i).getValue());
                } case SIZE -> {
                    removeSize(listOfParameters.get(i).getValue());
                }
            }
            currentCount = copyPoints.size() - listOfPoints.size();
            if (minOrMax == MinMax.MIN) {
                int prev = currentCount;
                buffer = Math.min(currentCount, buffer);
                if (buffer >= prev) {
                    operation =  new Pair<>(listOfParameters.get(i).getKey(), listOfParameters.get(i).getValue());
                }
            } else {
                int prev = currentCount;
                buffer = Math.max(currentCount, buffer);
                if (buffer <= prev) {
                    operation =  new Pair<>(listOfParameters.get(i).getKey(), listOfParameters.get(i).getValue());
                }
            }
            listOfPoints = new ArrayList<IPoint>(copyPoints);
        }
        switch (operation.getKey()) {
            case COUNT ->
                    removeCount(operation.getValue());
            case DATE ->
                    removeDate(operation.getValue());
            case SIZE ->
                    removeSize(operation.getValue());
        }
    }

    public void printPoints() {
        System.out.println("Count is: " + listOfPoints.size());
        System.out.println("Creation time of backup is: " + creationTime);
        for(IPoint i : listOfPoints) {
            System.out.print(i.getSizeOfFiles() + "MB ");
            i.printPoint();
            System.out.println();
        }
    }
}