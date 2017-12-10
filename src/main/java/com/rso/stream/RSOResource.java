package com.rso.stream;

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
@Path("rso")
@RequestScoped
public class RSOResource {

    @GET
    @Path("infectService")
    public Response makeServiceSick() {
        CustomHealthCheckService.isServiceHealthy = false;
        return Response.ok().build();
    }

    @GET
    @Path("overload/{n}")
    public Response makeServiceOverloaded(@PathParam("n") int n) {
        int fibonacci = fibonacci(n);
        return Response.ok(fibonacci).build();
    }

    @GET
    @Path("milestone1")
    public Response getMilestone1Data() {
        return Response.ok().build();
    }

    private static int fibonacci(int n) {
        if (n <= 1) return n;
        else return fibonacci(n - 1) + fibonacci(n - 2);
    }
}