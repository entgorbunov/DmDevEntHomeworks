package com.dmdev.supportServiceEmulator;


import com.dmdev.supportServiceEmulator.customExceptions.LogFileReadException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;

public class ComplaintLogReader {
    private final Path filePath;
    private final AtomicLong lastOffset = new AtomicLong(0);

    public ComplaintLogReader(Path filePath) {
        this.filePath = Paths.get(filePath.toUri());
    }

    public List<String> readNewComplaints() throws LogFileReadException {
        List<String> complaints = new ArrayList<>();
        try (Stream<String> lines = Files.lines(filePath)) {
            long skipLines = lastOffset.get();
            lines.skip(skipLines)
                    .forEachOrdered(line -> {
                        complaints.add(line);
                        lastOffset.incrementAndGet();
                    });
        } catch (IOException e) {
            throw new LogFileReadException("Ошибка чтения лог файла", e);
        }

        return complaints;
    }
}

