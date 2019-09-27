package com.isc.common.data.entity.mongodb.security;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Resource {
    @JsonProperty(value = "_id")
    private String id;
    private String path;
    private String method;
    private String name;
    private String icon;
    private String type;
    private String module;
    private Boolean active;
    private Boolean creationTime;

    enum Type {
        view, rest_api;
    }

    enum Module {
        operation, client;
    }
}
