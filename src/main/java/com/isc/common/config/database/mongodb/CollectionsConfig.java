package com.isc.common.config.database.mongodb;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.isc.common.config.database.mongodb.CollectionNamesConstant.POST;

@Configuration
public class CollectionsConfig {

    @Autowired private MongoDatabase mongoDatabase;

    @Bean
    public MongoCollection<Document> getMongoDatabase() {
        return mongoDatabase.getCollection(POST);
    }
}
