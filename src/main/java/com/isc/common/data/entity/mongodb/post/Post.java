package com.isc.common.data.entity.mongodb.post;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Post {
    private String id;
    private String title;
    private String content;
}
