package com.rso.stream;

import com.kumuluz.ee.discovery.annotations.RegisterService;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * Created by urbanmarovt on 13/11/2017.
 */
@RegisterService
@ApplicationPath("v1")
public class StreamApplication extends Application {
}
