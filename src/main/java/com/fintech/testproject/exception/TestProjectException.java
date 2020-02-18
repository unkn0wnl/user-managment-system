package com.fintech.testproject.exception;

public class TestProjectException extends RuntimeException {

    public TestProjectException() {
        super();
    }

    public TestProjectException(String message) {
        super(message);
    }

    public TestProjectException(String message, Throwable cause) {
        super(message, cause);
    }

    public TestProjectException(Throwable cause) {
        super(cause);
    }

    protected TestProjectException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}