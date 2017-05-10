package com.example.demo.restservice.api.handler.find;

import com.example.demo.restservice.api.handler.find.common.Comparators;
import com.example.demo.restservice.api.handler.find.common.TweetsCollectionResponse;
import com.example.demo.restservice.domain.tweets.TweetService;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Component
public class TweetsFindByAuthorRequestHandler {
    private TweetService tweetService;

    public TweetsFindByAuthorRequestHandler(TweetService tweetService) {
        this.tweetService = tweetService;
    }

    public @NotNull
    TweetsCollectionResponse handleRequest(
            @NotNull TweetsFindByAuthorRequest request
    ) {
        return TweetsCollectionResponse.of(
                tweetService
                        .findByAuthor(request.getAuthor())
                        .sorted((tweet1, tweet2) -> Comparators.compareInstant(
                                tweet1.getCreatedAt(),
                                tweet2.getCreatedAt(),
                                true
                                )
                        ));
    }
}
