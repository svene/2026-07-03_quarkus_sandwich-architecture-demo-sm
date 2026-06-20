package org.svenehrke.demo.inbound;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.svenehrke.demo.core.HelloInPort;

/**
 * Wrapper for `HelloInPort.hello()`.
 */
@Path("/hello")
public class GreetInAdapter {

    @Inject
    HelloInPort helloInPort;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return helloInPort.hello();
    }
}
