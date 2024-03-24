package com.dmdev.supportServiceEmulator.customExceptions;

public class CallInterruptedException extends CallDispatchException {
    public CallInterruptedException(String message, Throwable cause) {
        super(message, cause);
    }
}
