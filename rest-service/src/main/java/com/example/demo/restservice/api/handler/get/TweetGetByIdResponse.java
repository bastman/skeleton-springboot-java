package com.example.demo.restservice.api.handler.get;

import com.example.demo.restservice.domain.tweets.Tweet;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.validation.constraints.Null;
import java.util.Optional;

public class TweetGetByIdResponse {
    @Null private Tweet tweet;

    public TweetGetByIdResponse(@Null Tweet tweet) {
        this.tweet = tweet;
    }

    public static TweetGetByIdResponse of(Optional<Tweet> tweetOptional) {
        if(tweetOptional.isPresent()) {
            return new TweetGetByIdResponse(tweetOptional.get());
        }

        return new TweetGetByIdResponse(null);
    }

    @Null
    public Tweet getTweet() {
        return tweet;
    }

    public ResponseEntity<TweetGetByIdResponse> toResponseEntity() {
       if(this.tweet==null) {
           return ResponseEntity
                   .status(HttpStatus.NOT_FOUND)
                   .body(this);
       }

        return ResponseEntity
                .ok(this);

    }

}
