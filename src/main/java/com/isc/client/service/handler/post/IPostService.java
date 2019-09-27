package com.isc.client.service.handler.post;

import com.isc.common.data.entity.mongodb.post.Post;
import rx.Single;

public interface IPostService {
    Single<Post> getPostDetail(String postId);
}
