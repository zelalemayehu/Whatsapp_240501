package com.whatsapp.api.backend.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
@Getter
@Setter
@AllArgsConstructor
public class ChatAPIException {

    private final String  message;
    private final Throwable  throwable;
    private final HttpStatus httpStatus;

}
