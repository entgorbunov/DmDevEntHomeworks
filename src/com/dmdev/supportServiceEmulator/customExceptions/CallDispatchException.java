package com.dmdev.supportServiceEmulator.customExceptions;

public class CallDispatchException extends Exception {
    public CallDispatchException(String message) {
        super(message);
    }

    public CallDispatchException(String message, Throwable cause) {
        super(message, cause);
    }
}
