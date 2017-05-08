package com.example.demo.restservice.api.handler.submit;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.util.Objects;

public class TweetSubmitRequest {

    @NotNull
    private String author;
    @NotNull
    private String message;

    @JsonCreator
    public TweetSubmitRequest(
            @NotNull @JsonProperty(value = "author") String author,
            @NotNull @JsonProperty(value = "message") String message
    ) {
        Objects.requireNonNull(author);
        Objects.requireNonNull(message);
        this.author = author;
        this.message = message;
    }

    final public String getAuthor() {
        return author;
    }

    final public void setAuthor(String author) {
        this.author = author;
    }

    final public String getMessage() {
        return message;
    }

    final public void setMessage(String message) {
        this.message = message;
    }

}
