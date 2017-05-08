package com.example.demo.restservice.api;

import com.example.demo.restservice.api.handler.submit.TweetSubmitRequest;
import com.example.demo.restservice.api.handler.submit.TweetSubmitRequestHandler;
import com.example.demo.restservice.api.handler.submit.TweetSubmitResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class TweetApiController {
    private TweetSubmitRequestHandler tweetSubmitRequestHandler;
    //private val tweetGetByIdRequestHandler: TweetGetByIdRequestHandler,
    //private val tweetsFindByAuthorRequestHandler: TweetsFindByAuthorRequestHandler


    public TweetApiController(TweetSubmitRequestHandler tweetSubmitRequestHandler) {
        this.tweetSubmitRequestHandler = tweetSubmitRequestHandler;
    }

    @RequestMapping(
            value = ApiRoutes.TWEET_SUBMIT,
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    @ApiOperation(
            value = "submit a tweet",
            notes = "This adds a tweet to local in-memory store and returns a tweet id.",
            response = TweetSubmitResponse.class
    )
    TweetSubmitResponse submitTweet(
            @RequestBody TweetSubmitRequest request
    ) {
        return tweetSubmitRequestHandler.handleRequest(request);
    }

    public class ApiRequestFields {
        static final String TWEET_ID = "id";
        static final String AUTHOR = "author";
    }

    public class ApiRoutes {
        public static final String TWEET_GET_BY_ID = "/api/tweet/{" + ApiRequestFields.TWEET_ID + "}";
        public static final String TWEETS_FIND_BY_AUTHOR = "/api/author/{" + ApiRequestFields.AUTHOR + "}/tweets";
        static final String TWEET_SUBMIT = "/api/tweet/submit";
    }

}
