package com.clone.twitter.url_shortener_service;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableCaching
@SpringBootApplication
@EnableScheduling
@EnableFeignClients("com.clone.twitter.url_shortener_service.client")
public class UrlShortenerServiceApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(UrlShortenerServiceApplication.class)
                .bannerMode(Banner.Mode.OFF)
                .run(args);
    }
}