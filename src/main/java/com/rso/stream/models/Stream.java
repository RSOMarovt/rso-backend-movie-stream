package com.rso.stream.models;

import org.bson.Document;
import org.bson.types.ObjectId;

/**
 * Created by urbanmarovt on 13/11/2017.
 */
public class Stream {

    private String id;
    private String title;
    private String user_id;
    private String url;

    public Stream() {

    }

    public Stream(Document stream) {
        this.id = stream.getObjectId("_id").toString();
        this.user_id = stream.getObjectId("user_id").toString();
        this.title = stream.getString("title");
        this.url = stream.getString("url");

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Document createMongoElement() {

        Document doc = new Document();
        doc.append("user_id", new ObjectId(this.user_id));
        doc.append("title", this.title);
        doc.append("url", this.url);

        return doc;
    }
}
