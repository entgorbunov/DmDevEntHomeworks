package com.dmdev.supportServiceEmulator;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ComplaintLogReader {
    private final Path filePath;
    private long lastOffset = 0;

    public ComplaintLogReader(Path filePath) {
        this.filePath = filePath;
    }

    public List<String> readNewComplaints() {
        List<String> complaints = new ArrayList<>();
        try {
            RandomAccessFile file = new RandomAccessFile(String.valueOf(filePath), "r");
            file.seek(lastOffset);

            String line;
            while ((line = file.readLine()) != null) {
                complaints.add(line);
            }

            lastOffset = file.getFilePointer();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return complaints;
    }
}

