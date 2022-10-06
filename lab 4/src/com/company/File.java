package com.company;

import java.time.LocalDateTime;

public class File {
    private String name;
    private int size;
    private LocalDateTime creationTime;


    File(String name_, int size_, int numberOfMinutes) {
        if (size_ < 0) {
            throw new RuntimeException("Negative size of file");
        }
        name = name_;
        size = size_;
        creationTime = LocalDateTime.now().plusMinutes(numberOfMinutes);
    }

    String getName() {
        return name;
    }

    int getSize() {
        return size;
    }

    LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }
}
