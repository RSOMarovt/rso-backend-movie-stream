package com.rso.stream;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by urbanmarovt on 13/11/2017.
 */
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("streams")
public class StreamResource {

    @GET
    public Response getAllStreams() {
        List<Stream> customers = Database.getActiveStreams();
        return Response.ok(customers).build();
    }

    @GET
    @Path("{streamId}")
    public Response getStream(@PathParam("streamId") String streamId) {
        Stream customer = Database.getActiveStream(streamId);
        return customer != null
                ? Response.ok(customer).build()
                : Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    public Response addNewStream(Stream stream) {
        Database.addActiveStream(stream);
        return Response.noContent().build();
    }

    @DELETE
    @Path("{streamId}")
    public Response deleteStream(@PathParam("streamId") String streamId) {
        Database.deleteActiveStream(streamId);
        return Response.noContent().build();
    }
}