package com.example.demo.restservice.domain.tweets;

import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

@Component
public class TweetService {

    private TweetRepository repository;

    public TweetService(@NotNull TweetRepository repository) {
        this.repository = repository;
    }

    public final Tweet create(@NotNull String author, @NotNull String message) {
        final String id = System.nanoTime() + "-" + UUID.randomUUID();

        return new Tweet(
                id, Instant.now(), author, message
        );
    }

    public final void submit(@NotNull Tweet tweet) {
        this.repository.add(tweet);
    }

    public final Optional<Tweet> get(@NotNull String tweetId) {
        return repository.get(tweetId);
    }

    public final Stream<Tweet> getItems() {
        return repository.getItems();
    }

    public final Stream<Tweet> findByAuthor(@NotNull String author) {
        return getItems().filter((tweet) -> {
            return tweet.getAuthor().equals(author);
        });
    }
}
