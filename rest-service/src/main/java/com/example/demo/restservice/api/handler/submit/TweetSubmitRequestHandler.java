package com.example.demo.restservice.api.handler.submit;

import com.example.demo.restservice.domain.tweets.Tweet;
import com.example.demo.restservice.domain.tweets.TweetService;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Component
public class TweetSubmitRequestHandler {
    private TweetService tweetService;

    public TweetSubmitRequestHandler(@NotNull TweetService tweetService) {
        this.tweetService = tweetService;
    }

    public TweetSubmitResponse handleRequest(@NotNull TweetSubmitRequest request) {
        final Tweet tweet = tweetService.create(
                request.getAuthor(),
                request.getMessage()
        );

        tweetService.submit(tweet);

        return new TweetSubmitResponse(tweet.getId());
    }

}
