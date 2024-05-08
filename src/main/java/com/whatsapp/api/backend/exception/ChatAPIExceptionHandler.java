package com.whatsapp.api.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ChatAPIExceptionHandler {

    @ExceptionHandler(value = {BadRequestAlertException.class})
    public ResponseEntity<Object> handelChatAPIException(BadRequestAlertException chatAPIException){

        ChatAPIException chatAPIException1 = new ChatAPIException(
                chatAPIException.getMessage(), chatAPIException.getCause(), HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(chatAPIException1,HttpStatus.BAD_REQUEST);


    }
}
