package com.example.demo.restservice.domain.tweets;


import com.example.demo.logging.AppLogger;
import com.example.demo.restservice.DemoRestApplication;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.time.Duration;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

@Component
public class TweetRepository {
    private final Logger LOGGER = AppLogger.get(TweetRepository.class);

    private Cache<String, Tweet> cache;

    public TweetRepository() {
        final Duration expiry = Duration.ofDays(3);
        this.cache= Caffeine
                .newBuilder()
                .maximumSize(1_000_000)
                .expireAfterWrite(expiry.getSeconds(), TimeUnit.SECONDS)
                .build();
    }

    final void add(@NotNull Tweet item) {
        Objects.requireNonNull(item);
        cache.put(item.getId(), item);
        LOGGER.info("add item to repository. itemId="+item.getId());
    }
    final Optional<Tweet>get(@NotNull String itemId) {
        final Tweet tweet = this.cache.getIfPresent(itemId);
        return Optional.ofNullable(tweet);
    }
    final Stream<Tweet> getItems() {
        return cache.asMap().values().stream();
    }
}
