package com.isc.client.web.rest;

import com.isc.client.service.handler.post.IPostService;
import com.isc.common.data.response.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rx.Single;
import rx.schedulers.Schedulers;

@RestController
@RequestMapping(value = "/api/post")
public class PostResource {
    @Autowired
    private IPostService postService;

    @GetMapping(
            value = "/{postId}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Single<ResponseEntity<BaseResponse>> getPostDetail(@PathVariable(value = "postId") String postId) {
        return postService.getPostDetail(postId)
                .subscribeOn(Schedulers.io())
                .map(post -> ResponseEntity.ok(BaseResponse.successWithData(post)));
    }
}
