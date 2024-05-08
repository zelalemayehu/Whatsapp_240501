package com.whatsapp.api.backend.controller;

import com.whatsapp.api.backend.entity.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/v1/chat")
public class ChatController {

    @PostMapping("/register")
    public ChatMessage register(@RequestBody ChatMessage chatMessage, HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("username", chatMessage.getSender());
        return chatMessage;
    }

    @PostMapping("/send")
    public ChatMessage sendMessage(@RequestBody ChatMessage chatMessage) {
        return chatMessage;
    }

}
