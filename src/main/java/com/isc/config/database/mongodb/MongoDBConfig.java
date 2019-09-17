package com.isc.config.database.mongodb;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoDBConfig {

    @Autowired private MongoDBProperties mongoDBProperties;

    @Bean
    public MongoDatabase getMongoDatabase() {
        MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
        mongoClient.

                MongoClientURI uri = new MongoClientURI("mongodb://user1:pwd1@host1/?authSource=db1&authMechanism=SCRAM-SHA-1");
        MongoClient mongoClient = new MongoClient(uri);
    }
}
