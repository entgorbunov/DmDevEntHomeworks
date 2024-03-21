package com.dmdev.supportServiceEmulator;

import java.nio.file.Path;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        // Запускаем задачу с периодичностью 2 минуты
        executor.scheduleAtFixedRate(() -> {
            ComplaintLogReader reader = new ComplaintLogReader(Path.of("src", "complaints_log.txt"));
            CallDispatcher dispatcher = new CallDispatcher(Path.of("src", "call_log.txt"));

            reader.readNewComplaints().forEach(dispatcher::dispatchCall);
        }, 0, 2, TimeUnit.MINUTES);
    }
}
