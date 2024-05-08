package com.whatsapp.api.backend.service.emoji;

import com.whatsapp.api.backend.common.EmojiEnum;
import com.whatsapp.api.backend.entity.Emoji;
import com.whatsapp.api.backend.repository.EmojiRepository;
import com.whatsapp.api.backend.service.dto.EmojiDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmojiServiceImpl implements EmojiService{

    private final EmojiRepository emojiRepository;

    private final ModelMapper modelMapper;

    public EmojiServiceImpl(EmojiRepository emojiRepository, ModelMapper modelMapper) {
        this.emojiRepository = emojiRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public EmojiDTO addEmoji(EmojiDTO emojiDTO) {
        Emoji emoji = new Emoji();
        switch (emojiDTO.getEmoji()) {
            case "thumbup":
                emoji.setEmoji(EmojiEnum.THUMBUP.name());
                break;
            case "love":
                emoji.setEmoji(EmojiEnum.LOVE.name());
                break;
            case "crying":
                emoji.setEmoji(EmojiEnum.CRYING.name());
                break;
            case "suprised":
                emoji.setEmoji(EmojiEnum.SUPRISED.toString());
                break;
            default:
                throw new RuntimeException("Invalid emoji kind");
        }
        emoji.setMessageId(emojiDTO.getMessageId());

        Emoji savedEmoji = emojiRepository.save(emoji);

        return modelMapper.map(savedEmoji,EmojiDTO.class);

    }

    @Override
    public Optional<Emoji> getEmoji(Long messageId) {

        return emojiRepository.findByMessageId(messageId);
    }
}
