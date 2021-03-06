package com.example.demo.restservice.api.handler.find;

import com.example.demo.restservice.api.handler.find.common.Comparators;
import com.example.demo.restservice.api.handler.find.common.TweetsCollectionResponse;
import com.example.demo.restservice.domain.tweets.TweetService;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Component
public class TweetsFindAllRequestHandler {
    private TweetService tweetService;

    public TweetsFindAllRequestHandler(@NotNull TweetService tweetService) {
        this.tweetService = tweetService;
    }

    public TweetsCollectionResponse handleRequest() {
        return TweetsCollectionResponse.of(
                tweetService
                        .getItems()
                        .sorted((tweet1, tweet2) -> Comparators.compareInstant(
                                tweet1.getCreatedAt(),
                                tweet2.getCreatedAt(),
                                true
                                )
                        ));

    }
}
