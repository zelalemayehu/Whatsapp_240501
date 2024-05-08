package com.whatsapp.api.backend.service.dto;

import com.whatsapp.api.backend.common.MessageStatusEnum;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StatusDTO {
    Long messageId;
    MessageStatusEnum messageStatusEnum;
}
