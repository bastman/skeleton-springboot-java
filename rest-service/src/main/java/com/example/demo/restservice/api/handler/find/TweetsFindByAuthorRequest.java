package com.example.demo.restservice.api.handler.find;


import javax.validation.constraints.NotNull;
import java.util.Objects;

public class TweetsFindByAuthorRequest {
    @NotNull
    private String author;

    public TweetsFindByAuthorRequest(@NotNull String author) {
        Objects.requireNonNull(author);
        this.author = author;
    }

    @NotNull
    public String getAuthor() {
        return author;
    }
}
