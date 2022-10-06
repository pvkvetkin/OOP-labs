package com.company;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try {
            TimeChanger timeChanger = new TimeChanger();
            EcosystemOfBackups backups = new EcosystemOfBackups();
            Backup backup1 = new Backup(timeChanger.getNumberOfMinutes());
            File file1 = new File("1", 7, timeChanger.getNumberOfMinutes());
            File file2 = new File("2", 9, timeChanger.getNumberOfMinutes(DATE.MINUTES, 9));
            File file3 = new File("3", 37, timeChanger.getNumberOfMinutes(DATE.MINUTES, 2));
            File file4 = new File("4", 75, timeChanger.getNumberOfMinutes());
            File file5 = new File("5", 97, timeChanger.getNumberOfMinutes());
            ArrayList<File> fileArrayList = new ArrayList<>();
            fileArrayList.add(file1);
            fileArrayList.add(file2);
            FullPoint point1 = new FullPoint(fileArrayList, backup1.getIndex(), timeChanger.getNumberOfMinutes());
            backup1.addPoint(point1);
            fileArrayList.add(file3);
            IncrementalPoint point2 = new IncrementalPoint(fileArrayList, point1.getListOfFilesInPoints(), backup1.getIndex(), timeChanger.getNumberOfMinutes());
            backup1.addPoint(point2);
            IncrementalPoint point3 = new IncrementalPoint(fileArrayList, point2.getListOfFilesInPoints(), backup1.getIndex(), timeChanger.getNumberOfMinutes());
            backup1.addPoint(point3);
            fileArrayList.add(file4);
            FullPoint point4 = new FullPoint(fileArrayList, backup1.getIndex(), timeChanger.getNumberOfMinutes(DATE.MINUTES, 2));
            backup1.addPoint(point4);
            fileArrayList.add(file5);
            IncrementalPoint point5 = new IncrementalPoint(fileArrayList, point4.getListOfFilesInPoints(), backup1.getIndex(), timeChanger.getNumberOfMinutes());
            backup1.addPoint(point5);
            FullPoint point7 = new FullPoint(fileArrayList, backup1.getIndex(), timeChanger.getNumberOfMinutes());
            backup1.addPoint(point7);
            backups.put(backup1);
            fileArrayList.clear();
//            backup.removeCount(1); // count of deleted points 0
//            backup.removeDate(5);  // count of deleted points 3
//            backup.removeSize(325); // count of deleted points 5
//            ArrayList<Pair<Hybryd, Integer>> parameters = new ArrayList<>();
//            parameters.add(new Pair<Hybryd, Integer> (Hybryd.COUNT, 1));
//            parameters.add(new Pair<Hybryd, Integer> (Hybryd.DATE, 5));
//            parameters.add(new Pair<Hybryd, Integer> (Hybryd.SIZE, 325));
//            backup.removeHybryd(parameters, MinMax.MAX);
            Backup backup2 = new Backup(timeChanger.getNumberOfMinutes());
            backups.put(backup2);
            File file7 = new File("7", 75, timeChanger.getNumberOfMinutes());
            File file9 = new File("9", 98, timeChanger.getNumberOfMinutes(DATE.MINUTES, 2));
            fileArrayList.add(file7);
            FullPoint point8 = new FullPoint(fileArrayList, backup2.getIndex(), timeChanger.getNumberOfMinutes());
            backups.addInBackup(1, point8);
            fileArrayList.add(file9);
            IncrementalPoint point9 = new IncrementalPoint(fileArrayList, point8.getListOfFilesInPoints(), backup2.getIndex(), timeChanger.getNumberOfMinutes());
            backups.addInBackup(1, point9);
            System.out.println("Count of backups is: " + backups.getSize());
            for(int i = 0; i < backups.getSize(); ++i) {
                backups.printBackup(i);
            }
        }   catch (Exception error) {
            System.err.println(error.getMessage());
        }
    }
}
