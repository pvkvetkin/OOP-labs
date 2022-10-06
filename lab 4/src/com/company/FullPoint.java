package com.company;

import java.time.LocalDateTime;
import java.util.ArrayList;



public class FullPoint implements IPoint {
    private ArrayList<File> listOfFilesInPoints;
    private LocalDateTime creationTime;
    private InfoPoint typeOfPoint;
    private int index;

    FullPoint(ArrayList<File> listOfFilesInPoints_, int index_, int numberOfMinutes) {
        listOfFilesInPoints = new ArrayList<>(listOfFilesInPoints_);
        typeOfPoint = InfoPoint.FULL;
        creationTime = LocalDateTime.now().plusMinutes(numberOfMinutes);
        index_++;
        index = index_ ;
    }


    public ArrayList<File> getListOfFilesInPoints() {
        return listOfFilesInPoints;
    }

    public InfoPoint getTypeOfPoint() {
        return typeOfPoint;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public int getIndex() {
        return index;
    }

    public int getSizeOfFiles() {
        int sizeOfFiles = 0;
        for(File j : getListOfFilesInPoints()) {
            sizeOfFiles += j.getSize();
        }
        return sizeOfFiles;
    }

    public void printPoint() {
        System.out.print(getCreationTime());
        System.out.print("      ");
        System.out.print(getTypeOfPoint());
        System.out.print("      ");
        System.out.println(getIndex() + 1); // + 1 for a beautiful output
        if (listOfFilesInPoints.size() == 0) {
            System.out.println("Empty list of backup files");
        }
        for(File i : listOfFilesInPoints) {
            System.out.print(i.getName() + "   " + i.getSize() + "   " + i.getCreationTime() + '\n');
        }
    }
}



