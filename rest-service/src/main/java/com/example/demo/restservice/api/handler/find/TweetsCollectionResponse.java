package com.example.demo.restservice.api.handler.find;

import com.example.demo.restservice.domain.tweets.Tweet;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TweetsCollectionResponse {
    @NotNull
    private List<Tweet> tweets;

    public TweetsCollectionResponse(@NotNull List<Tweet> tweets) {
        this.tweets = tweets;
    }

    public static TweetsCollectionResponse of(
            @NotNull Stream<Tweet> tweets
    ) {
        return new TweetsCollectionResponse(
                tweets.collect(Collectors.toList())
        );
    }

    @NotNull
    public List<Tweet> getTweets() {
        return tweets;
    }
}
