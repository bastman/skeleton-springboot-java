package com.example.demo.restservice.api;

import com.example.demo.restservice.api.handler.find.common.TweetsCollectionResponse;
import com.example.demo.restservice.api.handler.find.TweetsFindAllRequestHandler;
import com.example.demo.restservice.api.handler.find.TweetsFindByAuthorRequest;
import com.example.demo.restservice.api.handler.find.TweetsFindByAuthorRequestHandler;
import com.example.demo.restservice.api.handler.get.TweetGetByIdRequest;
import com.example.demo.restservice.api.handler.get.TweetGetByIdRequestHandler;
import com.example.demo.restservice.api.handler.get.TweetGetByIdResponse;
import com.example.demo.restservice.api.handler.submit.TweetSubmitRequest;
import com.example.demo.restservice.api.handler.submit.TweetSubmitRequestHandler;
import com.example.demo.restservice.api.handler.submit.TweetSubmitResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class TweetApiController {
    private TweetSubmitRequestHandler tweetSubmitRequestHandler;
    private TweetGetByIdRequestHandler tweetGetByIdRequestHandler;
    private TweetsFindAllRequestHandler tweetsFindAllRequestHandler;
    private TweetsFindByAuthorRequestHandler tweetsFindByAuthorRequestHandler;

    public TweetApiController(
            TweetSubmitRequestHandler tweetSubmitRequestHandler,
            TweetGetByIdRequestHandler tweetGetByIdRequestHandler,
            TweetsFindAllRequestHandler tweetsFindAllRequestHandler,
            TweetsFindByAuthorRequestHandler tweetsFindByAuthorRequestHandler
    ) {
        this.tweetSubmitRequestHandler = tweetSubmitRequestHandler;
        this.tweetGetByIdRequestHandler = tweetGetByIdRequestHandler;
        this.tweetsFindAllRequestHandler = tweetsFindAllRequestHandler;
        this.tweetsFindByAuthorRequestHandler = tweetsFindByAuthorRequestHandler;
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


    @RequestMapping(
            value = ApiRoutes.TWEET_GET_BY_ID,
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    @ApiOperation(
            value = "get tweet by id",
            notes = "returns nothing if not found.",
            response = TweetGetByIdResponse.class
    )
    ResponseEntity<TweetGetByIdResponse> getTweetById(
            @PathVariable(name = ApiRequestFields.TWEET_ID) String tweetId
    ) {
        return tweetGetByIdRequestHandler
                .handleRequest(new TweetGetByIdRequest(tweetId))
                .toResponseEntity();
    }

    @RequestMapping(
            value = ApiRoutes.TWEETS_FIND_ALL,
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    @ApiOperation(
            value = "find all tweets",
            notes = "returns empty collection if nothing found.",
            response = TweetsCollectionResponse.class
    )
    public TweetsCollectionResponse findAllTweets() {
        return tweetsFindAllRequestHandler
                .handleRequest();
    }

    @RequestMapping(
            value = ApiRoutes.TWEETS_FIND_BY_AUTHOR,
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    @ApiOperation(
            value = "find all tweets by author",
            notes = "returns empty collection if nothing found.",
            response = TweetsCollectionResponse.class
    )
    public TweetsCollectionResponse findTweetsByAuthor(
            @PathVariable(name = ApiRequestFields.AUTHOR) String author
    ) {
        return tweetsFindByAuthorRequestHandler
                .handleRequest(new TweetsFindByAuthorRequest(author));
    }

    public class ApiRequestFields {
        static final String TWEET_ID = "id";
        static final String AUTHOR = "author";
    }

    public class ApiRoutes {
        static final String TWEET_GET_BY_ID = "/api/tweet/{" + ApiRequestFields.TWEET_ID + "}";
        static final String TWEETS_FIND_ALL = "/api/tweet";
        static final String TWEETS_FIND_BY_AUTHOR = "/api/author/{" + ApiRequestFields.AUTHOR + "}/tweets";
        static final String TWEET_SUBMIT = "/api/tweet/submit";
    }

}
