package com.dmdev.supportServiceEmulator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CallDispatcher {
    private final Path logFilePath;

    public CallDispatcher(Path logFilePath) {
        this.logFilePath = logFilePath;
    }

    public void dispatchCall(String complaint) {
        String[] parts = complaint.split(", ");
        String customerId = parts[0];
        String phoneNumber = Utils.formatPhoneNumber(parts[3]);

        // Симулируем длительность звонка
        try {
            Thread.sleep((long) (3000 + Math.random() * 2000));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Записываем результат в лог-файл
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(String.valueOf(logFilePath), true))) {
            writer.write(String.format("%s, %s, %s\n", customerId, LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")), phoneNumber));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

