package com.whatsapp.api.backend.controller;

import com.whatsapp.api.backend.service.dto.MessageDTO;
import com.whatsapp.api.backend.service.dto.StatusDTO;
import com.whatsapp.api.backend.service.message.MessageService;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/message")
public class MessageController {
    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/contactMessages")
    public ResponseEntity<Page<MessageDTO>> getAllContactMessage( Pageable pageable,
            @RequestParam(value = "contactId") Long contactId) {

        Page<MessageDTO> messageDTOS= messageService.getContactMessage(pageable, contactId);

        return new ResponseEntity<>(messageDTOS, HttpStatus.OK);
    }

    @PostMapping("/sentTextMessage")
    public ResponseEntity<MessageDTO> uploadFile(@RequestBody MessageDTO messageDTO) {

        MessageDTO response = messageService.sentTextMessage(messageDTO);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/sentMultipartFileMessage")
    public ResponseEntity<MessageDTO> uploadFile(
            @RequestParam("file") MultipartFile multipartFile, @RequestBody MessageDTO messageDTO)
            throws IOException {

         MessageDTO response = messageService.sentMultipartFileMessage(multipartFile, messageDTO);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PatchMapping("/changeStatus")
    public ResponseEntity<MessageDTO> changeMessageStatus(@RequestBody StatusDTO statusDTO){

        MessageDTO response = messageService.changeMessageStatus(statusDTO);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/downloadFile/{fileCode}")
    public ResponseEntity<?> downloadFile(@PathVariable("fileCode") Long fileCode) {

        Resource resource = null;
        try {
            resource = messageService.downloadFile(fileCode);

        } catch (IOException e) {
            return ResponseEntity.internalServerError().build();
        }

        if (resource == null) {

            return new ResponseEntity<>("File not found", HttpStatus.NOT_FOUND);
        }

        String contentType = "application/octet-stream";
        String headerValue = "attachment; filename=\"" + resource.getFilename() + "\"";

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, headerValue)
                .body(resource);
    }
}
