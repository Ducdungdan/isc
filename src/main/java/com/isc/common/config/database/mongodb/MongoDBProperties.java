package com.isc.common.config.database.mongodb;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "isc.database.mongodb")
public class MongoDBProperties {

    private String host;
    private String port;
    private String username;
    private String password;
    private String databaseName;
}