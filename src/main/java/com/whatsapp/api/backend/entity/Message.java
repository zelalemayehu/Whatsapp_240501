package com.whatsapp.api.backend.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @Column(name = "message_type")
    private String messageType;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private Contact sender;

    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private Contact receiver;

    private String Status;
}

