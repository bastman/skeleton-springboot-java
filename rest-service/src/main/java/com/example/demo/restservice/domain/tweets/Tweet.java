package com.example.demo.restservice.domain.tweets;

import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.Objects;

/*
data class Tweet(
        val id: String,
        val createdAt: Instant,
        val author: String,
        val message: String
)
 */

public class Tweet {

    @NotNull
    private String id;
    @NotNull
    private Instant createdAt;
    @NotNull
    private String author;
    @NotNull
    private String message;

    public Tweet(
            @NotNull String id,
            @NotNull Instant createdAt,
            @NotNull String author,
            @NotNull String message
    ) {
        Objects.requireNonNull(id);
        Objects.requireNonNull(createdAt);
        Objects.requireNonNull(author);
        Objects.requireNonNull(message);
        this.id = id;
        this.createdAt = createdAt;
        this.author = author;
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public String getAuthor() {
        return author;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tweet tweet = (Tweet) o;

        if (!id.equals(tweet.id)) return false;
        if (!createdAt.equals(tweet.createdAt)) return false;
        if (!author.equals(tweet.author)) return false;
        return message.equals(tweet.message);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + createdAt.hashCode();
        result = 31 * result + author.hashCode();
        result = 31 * result + message.hashCode();
        return result;
    }
}

