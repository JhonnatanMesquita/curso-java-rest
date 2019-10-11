package com.stefanini.hackaton.rest.config;

public class ErrorMessage {

    private String message;
    private Integer statusCode;
    private String stackTrace;

    public ErrorMessage() {
    }

    public ErrorMessage(String message, Integer statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }

    public ErrorMessage(String message, Integer statusCode, String stackTrace) {
        this.message = message;
        this.statusCode = statusCode;
        this.stackTrace = stackTrace;
    }

    public String getStackTrace() {
        return stackTrace;
    }

    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }
}
