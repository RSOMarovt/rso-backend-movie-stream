package com.rso.stream.resources;

import com.kumuluz.ee.logs.cdi.Log;
import com.rso.stream.mongodb.Database;
import com.rso.stream.models.Stream;
import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.Gauge;
import org.eclipse.microprofile.metrics.annotation.Timed;

import javax.enterprise.context.RequestScoped;
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
@Log
@RequestScoped
public class StreamResource {

    @GET
    @Gauge(name = "active_streams_length", unit = MetricUnits.NONE)
    public Response getAllStreams() {

        List<Stream> streams = Database.getActiveStreams();
        return Response.ok(streams).build();
    }

    @GET
    @Path("{streamId}")
    public Response getStream(@PathParam("streamId") String streamId) {
        Database database = new Database();
        Stream customer = database.getActiveStream(streamId);
        return customer != null
                ? Response.ok(customer).build()
                : Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @Timed(name = "add_active_stream_timer")
    public Response addNewStream(Stream stream) {
        String id = Database.addActiveStream(stream);
        return id != null
                ? Response.ok(id).build()
                : Response.status(Response.Status.BAD_REQUEST).build();
    }
}