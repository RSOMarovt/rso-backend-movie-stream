package com.rso.stream.mongodb;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.rso.stream.models.Stream;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by urbanmarovt on 13/11/2017.
 */
public class Database {
    private static List<Stream> activeStreams = new ArrayList<Stream>();


    public static List<Stream> getActiveStreams() {
        MongoClientProvider mcp = new MongoClientProvider();

        MongoCollection collection = mcp.getCollection("Streams");

        MongoCursor<Document> cursor = collection.find().iterator();

        List<Stream> returnStreams = new ArrayList<Stream>();

        try {
            while (cursor.hasNext()) {
                Document doc = cursor.next();

                returnStreams.add(new Stream(doc));
            }
        } finally {
            cursor.close();
        }

        return returnStreams;
    }

    public Stream getActiveStream(String streamId) {
        MongoClientProvider mcp = new MongoClientProvider();

        MongoCollection collection = mcp.getCollection("Streams");

        try {
            ObjectId objectId = new ObjectId(streamId);
            Document doc = new Document("_id", objectId);
            Document query = Document.parse(doc.toJson());

            MongoCursor<Document> cursor = collection.find(query).iterator();

            List<Stream> returnStreams = new ArrayList<Stream>();

            return new Stream(cursor.next());
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public static String addActiveStream(Stream stream) {
        MongoClientProvider mcp = new MongoClientProvider();

        MongoCollection collection = mcp.getCollection("Streams");

        Document doc = stream.createMongoElement();

        collection.insertOne(doc);

        ObjectId id = (ObjectId)doc.get( "_id" );

        return id.toString();
    }

}