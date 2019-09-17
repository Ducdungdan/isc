package com.isc.config.database.mongodb;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
@ConfigurationProperties(prefix = "isc.database.mongodb")
public class MongoDBProperties {

    private String host;
    private String port;
    private String username;
    private String password;
    private String databaseName;


}