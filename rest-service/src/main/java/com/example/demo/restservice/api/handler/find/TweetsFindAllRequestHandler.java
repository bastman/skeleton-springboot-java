package com.example.demo.restservice.api.handler.find;

import com.example.demo.restservice.domain.tweets.TweetService;
import org.springframework.stereotype.Component;

@Component
public class TweetsFindAllRequestHandler {
    private TweetService tweetService;

    public TweetsFindAllRequestHandler(TweetService tweetService) {
        this.tweetService = tweetService;
    }

    public TweetsCollectionResponse handleRequest() {
        return TweetsCollectionResponse.of(
                tweetService
                        .getItems()
        );
    }
}