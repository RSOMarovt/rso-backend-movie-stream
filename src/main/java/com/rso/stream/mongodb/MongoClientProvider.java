package com.rso.stream.mongodb;

import com.mongodb.MongoClient;

public class MongoClientProvider {
    private static MongoClient mongoClient = null;
    protected MongoClientProvider() {
        // Exists only to defeat instantiation.
    }
    public static MongoClient getInstance() {
        if(mongoClient == null) {
            String mongoString = "ec2-52-214-16-215.eu-west-1.compute.amazonaws.com";
            mongoClient = new MongoClient(mongoString);
        }
        return mongoClient;
    }
}