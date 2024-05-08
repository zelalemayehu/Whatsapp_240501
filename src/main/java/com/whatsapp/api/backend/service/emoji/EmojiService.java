package com.whatsapp.api.backend.service.emoji;

import com.whatsapp.api.backend.entity.Emoji;
import com.whatsapp.api.backend.service.dto.EmojiDTO;

import java.util.Optional;

public interface EmojiService {

    EmojiDTO addEmoji(EmojiDTO emojiDTO);

    Optional<Emoji> getEmoji(Long messageId);
}
