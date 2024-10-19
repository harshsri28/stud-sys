package com.system.student.exception;

public class StudentException extends RuntimeException{
    private int statusCode = 501;

    public StudentException(int statusCode) {
        this.statusCode = statusCode;
    }

    public StudentException(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
    }

    public StudentException(String message, Throwable cause, int statusCode) {
        super(message, cause);
        this.statusCode = statusCode;
    }

    public StudentException(Throwable cause, int statusCode) {
        super(cause);
        this.statusCode = statusCode;
    }

    public StudentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, int statusCode) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
