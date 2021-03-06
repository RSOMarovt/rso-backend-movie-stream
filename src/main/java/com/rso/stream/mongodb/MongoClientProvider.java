package com.rso.stream.mongodb;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.rso.stream.ConfigProperties;

import javax.inject.Inject;

public class MongoClientProvider {

    @Inject
    private ConfigProperties configProps;

    private static MongoClient mongoClient = null;
    protected MongoClientProvider() {
        // Exists only to defeat instantiation.
    }
    public MongoClient getInstance() {
        if(mongoClient == null) {
            String mongoString = "ec2-52-214-16-215.eu-west-1.compute.amazonaws.com";
            mongoClient = new MongoClient(mongoString);
        }
        return mongoClient;
    }

    public MongoCollection getCollection(String collectionName) {

        MongoClient mongoClient = this.getInstance();

        MongoDatabase db = mongoClient.getDatabase("rso-streams");

        return db.getCollection(collectionName);
    }
}