package com.isc.common.config.database.mongodb;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.isc.common.config.constant.DatabaseConstant.URI_CONNECT_MONGODB;
import static com.isc.common.utils.StringUtils.fillDataToStringInterpolation;

@Configuration
public class MongoDBConfig {

    @Autowired
    private MongoDBProperties mongoDBProperties;

    @Bean
    public MongoDatabase mongoDatabase() {
        MongoClientURI uri = new MongoClientURI(fillDataToStringInterpolation(URI_CONNECT_MONGODB, mongoDBProperties));
        MongoClient mongoClient = new MongoClient(uri);
        return mongoClient.getDatabase(mongoDBProperties.getDatabaseName());
    }
}
