package com.fintech.testproject.exception;

public class AppServiceException extends TestProjectException {

    public AppServiceException() {
        super();
    }

    public AppServiceException(String message) {
        super(message);
    }

    public AppServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public AppServiceException(Throwable cause) {
        super(cause);
    }

    protected AppServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}