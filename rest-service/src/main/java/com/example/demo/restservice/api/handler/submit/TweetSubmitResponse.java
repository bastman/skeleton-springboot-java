package com.example.demo.restservice.api.handler.submit;

import javax.validation.constraints.NotNull;
import java.util.Objects;


public class TweetSubmitResponse {
    @NotNull
    private String id;

    TweetSubmitResponse(@NotNull String id) {
        Objects.requireNonNull(id);
        this.id = id;
    }

    public String getId() {
        return id;
    }


}
