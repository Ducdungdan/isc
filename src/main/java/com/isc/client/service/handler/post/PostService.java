package com.isc.client.service.handler.post;

import com.isc.common.data.entity.post.Post;
import org.springframework.stereotype.Component;
import rx.Single;

@Component
public class PostService implements IPostService {

    @Override
    public Single<Post> getPostDetail(String postId) {
        return Single.just(
                new Post()
                .setId("1")
                .setTitle("một lần đau")
                .setContent("Thà đau một lần rồi thôi")
        );
    }
}
