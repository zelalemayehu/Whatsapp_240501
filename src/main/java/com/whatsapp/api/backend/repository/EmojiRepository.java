package com.whatsapp.api.backend.repository;

import com.whatsapp.api.backend.entity.Emoji;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmojiRepository extends JpaRepository<Emoji,Long> {

    Optional<Emoji> findByMessageId(Long messageI);
}
