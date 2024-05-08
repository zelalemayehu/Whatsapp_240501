package com.whatsapp.api.backend.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MessageDTO {

    private Long id;

    private String content;

    private String messageType;

    private LocalDateTime createdDate;

    private Long sender;

    private Long receiver;

    private String ContactId;

    private String Status;
}
