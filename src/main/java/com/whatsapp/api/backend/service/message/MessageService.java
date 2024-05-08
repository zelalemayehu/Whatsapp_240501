package com.whatsapp.api.backend.service.message;

import com.whatsapp.api.backend.service.dto.MessageDTO;
import com.whatsapp.api.backend.service.dto.StatusDTO;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface MessageService {

    Page<MessageDTO> getContactMessage(Pageable pageable, Long contactId);

    MessageDTO sentTextMessage(MessageDTO messageDTO);

    MessageDTO sentMultipartFileMessage(MultipartFile file, MessageDTO messageDTO) throws IOException;

    MessageDTO  changeMessageStatus(StatusDTO statusDTO);

    Resource downloadFile(Long messageId) throws IOException;
}
