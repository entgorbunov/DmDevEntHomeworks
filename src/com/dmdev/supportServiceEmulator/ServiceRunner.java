package com.dmdev.supportServiceEmulator;

import com.dmdev.supportServiceEmulator.customExceptions.CallDispatchException;
import com.dmdev.supportServiceEmulator.customExceptions.LogFileReadException;

import java.nio.file.Path;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ServiceRunner {
    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        ExecutorService callExecutors = Executors.newFixedThreadPool(3);

        scheduler.scheduleAtFixedRate(() -> {
            ComplaintLogReader reader = new ComplaintLogReader(Path.of("src", "resources", "complaints.log"));
            CallDispatcher dispatcher = new CallDispatcher(Path.of("src", "resources", "call.log"));

            try {
                reader.readNewComplaints().forEach(complaint ->
                        callExecutors.submit(() -> {
                            try {
                                dispatcher.dispatchCall(complaint);
                            } catch (CallDispatchException e) {
                                System.err.println("Произошла ошибка во время вызова диспетчера: " + e.getMessage());
                                e.printStackTrace();
                            }
                        })
                );
            } catch (LogFileReadException e) {
                System.err.println("Произошла ошибка во время чтения лог файла: " + e.getMessage());
                e.printStackTrace();
                shutdownAndAwaitTermination(scheduler, callExecutors);
            }
        }, 0, 2, TimeUnit.MINUTES);

    }

    private static void shutdownAndAwaitTermination(ExecutorService scheduler, ExecutorService callExecutors) {
        scheduler.shutdown();
        callExecutors.shutdown();
        try {
            if (!callExecutors.awaitTermination(1, TimeUnit.MINUTES)) {
                callExecutors.shutdownNow();
            }
            if (!scheduler.awaitTermination(1, TimeUnit.MINUTES)) {
                scheduler.shutdownNow();
            }
        } catch (InterruptedException e) {
            callExecutors.shutdownNow();
            scheduler.shutdownNow();
            Thread.currentThread().interrupt();
        }
        System.out.println("Программа завершила свою работу");
    }
}
