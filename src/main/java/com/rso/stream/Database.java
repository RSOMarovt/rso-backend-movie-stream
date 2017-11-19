package com.rso.stream;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by urbanmarovt on 13/11/2017.
 */
public class Database {
    private static List<Stream> activeStreams = new ArrayList<Stream>();

    public static List<Stream> getActiveStreams() {
        return activeStreams;
    }

    public static Stream getActiveStream(String streamId) {
        for (Stream stream : activeStreams) {
            if (stream.getId().equals(streamId))
                return stream;
        }

        return null;
    }

    public static void addActiveStream(Stream stream) {
        activeStreams.add(stream);
    }

    public static void deleteActiveStream(String streamId) {
        for (Stream stream : activeStreams) {
            if (stream.getId().equals(streamId)) {
                activeStreams.remove(stream);
                break;
            }
        }
    }
}