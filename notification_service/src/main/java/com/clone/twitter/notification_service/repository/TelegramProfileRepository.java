package com.clone.twitter.notification_service.repository;

import com.clone.twitter.notification_service.entity.TelegramProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TelegramProfileRepository extends JpaRepository<TelegramProfile, Long> {

    Optional<TelegramProfile> findByUserId(long userId);

    Optional<TelegramProfile> findByChatId(long chatId);

    boolean existsByChatId(long chatId);
}
