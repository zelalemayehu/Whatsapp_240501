package com.whatsapp.api.backend.entity;

import com.whatsapp.api.backend.common.EmojiEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "emoji")
public class Emoji {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String emoji;
    private Long messageId;
}
