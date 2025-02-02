package com.clone.twitter.notification_service.service.telegram;

import com.clone.twitter.notification_service.entity.TelegramProfile;
import com.clone.twitter.notification_service.exception.NotFoundException;
import com.clone.twitter.notification_service.repository.TelegramProfileRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class TelegramProfileServiceImpl implements TelegramProfileService {

    private final TelegramProfileRepository telegramProfileRepository;

    @Override
    @Transactional
    public void save(TelegramProfile telegramProfile) {
        telegramProfileRepository.save(telegramProfile);
        log.info("Saved new TelegramProfile with chatId={} for user with userId={}", telegramProfile.getChatId(),  telegramProfile.getUserId());
    }

    @Override
    @Transactional(readOnly = true)
    public TelegramProfile findByUserId(Long userId) {
        return telegramProfileRepository.findByUserId(userId)
                .orElseThrow(() -> new NotFoundException("Telegram profile with userId=" + userId + " not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<TelegramProfile> findByChatId(long chatId) {
        return telegramProfileRepository.findByChatId(chatId);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsByChatId(long chatId) {
        return telegramProfileRepository.existsByChatId(chatId);
    }
}
