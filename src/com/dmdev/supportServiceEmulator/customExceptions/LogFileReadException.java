package com.dmdev.supportServiceEmulator.customExceptions;

public class LogFileReadException extends Exception {
    public LogFileReadException(String message, Throwable cause) {
        super(message, cause);
    }
}
