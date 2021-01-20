package com.app.statistic.exceptions;

public class OperationNotSupportedException extends RuntimeException {

    public OperationNotSupportedException() {}

    public OperationNotSupportedException(String message) {
        super(message);
    }

    public OperationNotSupportedException(String message, Throwable cause) {
        super(message, cause);
    }

}
