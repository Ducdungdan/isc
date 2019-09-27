package com.isc.common.data.entity.mongodb.security;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class Permission {
    @JsonProperty(value = "_id")
    private String id;
    private String name;
    private String parentId;
    private List<String> resourceIds;
    private String type;
    private String module;
    private Boolean active;
    private Boolean creationTime;

    enum Type {
        menu, rest_api;
    }

    enum Module {
        operation, client;
    }
}
