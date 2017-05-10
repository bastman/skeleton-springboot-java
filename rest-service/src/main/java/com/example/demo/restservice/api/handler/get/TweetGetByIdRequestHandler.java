package com.example.demo.restservice.api.handler.get;


import com.example.demo.restservice.domain.tweets.Tweet;
import com.example.demo.restservice.domain.tweets.TweetService;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.Optional;

@Component
public class TweetGetByIdRequestHandler {
    private TweetService tweetService;

    public TweetGetByIdRequestHandler(@NotNull TweetService tweetService) {
        this.tweetService = tweetService;
    }

    public TweetGetByIdResponse handleRequest(
            @NotNull TweetGetByIdRequest request
    ) {
        Objects.requireNonNull(request);

        Optional<Tweet> tweet = tweetService.get(request.getId());

        return TweetGetByIdResponse.of(tweet);
    }
}
