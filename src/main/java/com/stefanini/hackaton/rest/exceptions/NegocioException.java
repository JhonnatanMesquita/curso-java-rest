package com.stefanini.hackaton.rest.exceptions;

public class NegocioException extends Exception {

    public NegocioException(String message) {
        super(message);
    }

    public NegocioException(final Throwable cause) {
        super(cause);
    }

    public NegocioException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
