package com.isc.common.data.entity.post;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Post {
    private String id;
    private String title;
    private String content;
}
