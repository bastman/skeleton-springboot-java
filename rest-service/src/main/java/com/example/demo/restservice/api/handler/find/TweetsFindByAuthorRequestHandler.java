package com.example.demo.restservice.api.handler.find;

import com.example.demo.restservice.domain.tweets.TweetService;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.util.Arrays;

@Component
public class TweetsFindByAuthorRequestHandler {
    private TweetService tweetService;

    public @NotNull TweetsCollectionResponse handleRequest(
            @NotNull TweetsFindByAuthorRequest request
    ) {
        return TweetsCollectionResponse.of(
                tweetService.findByAuthor(request.getAuthor())
        );
    }
}
