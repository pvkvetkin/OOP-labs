package com.company;

import java.time.LocalDateTime;
import java.util.ArrayList;

enum InfoPoint {
        FULL,
        INCREMENTAL
}

public interface IPoint {
        ArrayList<File> getListOfFilesInPoints ();

        InfoPoint getTypeOfPoint();

        LocalDateTime getCreationTime ();

        int getIndex ();

        int getSizeOfFiles ();

        void printPoint ();
}
