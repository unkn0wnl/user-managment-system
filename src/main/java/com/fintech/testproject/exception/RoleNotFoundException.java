package com.fintech.testproject.exception;

public class RoleNotFoundException extends AppServiceException {

    public RoleNotFoundException() {
        super();
    }

    public RoleNotFoundException(String message) {
        super(message);
    }

    public RoleNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public RoleNotFoundException(Throwable cause) {
        super(cause);
    }

    protected RoleNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}