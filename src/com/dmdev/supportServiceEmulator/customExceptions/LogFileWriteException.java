package com.dmdev.supportServiceEmulator.customExceptions;


public class LogFileWriteException extends CallDispatchException {
    public LogFileWriteException(String message, Throwable cause) {
        super(message, cause);
    }
}
