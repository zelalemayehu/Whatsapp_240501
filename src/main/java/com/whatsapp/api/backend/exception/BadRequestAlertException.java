package com.whatsapp.api.backend.exception;

/**
 * all responses rather than success treated as bad request
 * */
public class BadRequestAlertException extends RuntimeException {

    public BadRequestAlertException(String message){
        super(message);
    }

    public BadRequestAlertException(String message, Throwable causes){
        super(message, causes);
    }

}
