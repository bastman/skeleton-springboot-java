package com.example.demo.restservice.api.handler.get;


import javax.validation.constraints.NotNull;
import java.util.Objects;

public class TweetGetByIdRequest {
    @NotNull
    private String id;

    public TweetGetByIdRequest(@NotNull String id) {
        Objects.requireNonNull(id);
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
