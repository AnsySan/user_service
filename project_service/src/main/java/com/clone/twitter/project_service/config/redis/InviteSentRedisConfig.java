package com.clone.twitter.project_service.config.redis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.listener.ChannelTopic;

@Configuration
public class InviteSentRedisConfig {

    @Value("${spring.data.redis.channels.invitation_channel.name}")
    private String topicName;

    @Bean
    public ChannelTopic inviteSentTopic() {
        return new ChannelTopic(topicName);
    }
}
