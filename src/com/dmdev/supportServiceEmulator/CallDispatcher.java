package com.dmdev.supportServiceEmulator;

import com.dmdev.supportServiceEmulator.customExceptions.CallDispatchException;
import com.dmdev.supportServiceEmulator.customExceptions.CallInterruptedException;
import com.dmdev.supportServiceEmulator.customExceptions.LogFileWriteException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CallDispatcher {
    private final Path logFilePath;

    public CallDispatcher(Path logFilePath) {
        this.logFilePath = logFilePath;
    }

    public void dispatchCall(String complaint) throws CallDispatchException {
        try {
            Thread.sleep((long) (3000 + Math.random() * 2000));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new CallInterruptedException("Звонок был прерван", e);
        }

        processComplaint(complaint, logEntry -> {
            try {
                Files.write(logFilePath, logEntry.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private void processComplaint(String complaint, IOConsumer<String> ioConsumer) throws LogFileWriteException {
        String[] parts = complaint.split(", ");
        String customerId = parts[0];
        String phoneNumber = FormatNumber.formatPhoneNumber(parts[3]);

        String logEntry = String.format("%s, %s, %s\n", customerId,
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")), phoneNumber);

        try {
            ioConsumer.accept(logEntry);
        } catch (IOException e) {
            throw new LogFileWriteException("Запись в лог файл прервана", e);
        }
    }
}
