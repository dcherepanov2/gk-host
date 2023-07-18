package org.example.exception;

public class MissingSecondRecordException extends RuntimeException{
    public MissingSecondRecordException(String message) {
        super(message);
    }
}
