package com.whatsapp.api.backend.controller;

import com.whatsapp.api.backend.service.dto.EmojiDTO;
import com.whatsapp.api.backend.service.emoji.EmojiService;
import org.apache.http.protocol.HTTP;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/emoji")
public class EmojiController {

    private final EmojiService emojiService;

    public EmojiController(EmojiService emojiService) {
        this.emojiService = emojiService;
    }

    @PostMapping("")
    public ResponseEntity<EmojiDTO> addResponse(@RequestBody EmojiDTO emojiDTO) {

        return new ResponseEntity<>(emojiService.addEmoji(emojiDTO), HttpStatus.CREATED);
    }
}
