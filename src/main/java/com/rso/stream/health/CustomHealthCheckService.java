package com.rso.stream.health;


import org.eclipse.microprofile.health.Health;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;

import javax.enterprise.context.ApplicationScoped;
import java.util.logging.Logger;

/**
 * Created by urbanmarovt on 19/11/2017.
 */
@Health
@ApplicationScoped
public class CustomHealthCheckService implements HealthCheck {


    private static final Logger LOG = Logger.getLogger(CustomHealthCheckService.class.getSimpleName());
    public static boolean isServiceHealthy = true;

    @Override
    public HealthCheckResponse call() {
        try {

            if (isServiceHealthy) {
                return HealthCheckResponse.named(CustomHealthCheckService.class.getSimpleName()).up().build();
            }
        } catch (Exception exception) {
            LOG.severe(exception.getMessage());
        }
        return HealthCheckResponse.named(CustomHealthCheckService.class.getSimpleName()).down().build();
    }
}
