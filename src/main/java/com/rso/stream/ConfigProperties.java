package com.rso.stream;

import com.kumuluz.ee.configuration.cdi.ConfigBundle;

/**
 * Created by urbanmarovt on 07/01/2018.
 */

@ConfigBundle("config-properties")
public class ConfigProperties {

    private String mongoUrl;
    private String mongoDatabase;

    public String getMongoUrl() {
        return mongoUrl;
    }

    public void setMongoUrl(String mongoUrl) {
        this.mongoUrl = mongoUrl;
    }

    public String getMongoDatabase() {
        return mongoDatabase;
    }

    public void setMongoDatabase(String mongoDatabase) {
        this.mongoDatabase = mongoDatabase;
    }
}
