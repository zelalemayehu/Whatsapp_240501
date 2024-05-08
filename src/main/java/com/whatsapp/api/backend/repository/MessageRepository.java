package com.whatsapp.api.backend.repository;

import com.whatsapp.api.backend.entity.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    Page<Message> findMessagesByReceiverOrSender(Pageable pageable, Long receiver, long Sender);


}
