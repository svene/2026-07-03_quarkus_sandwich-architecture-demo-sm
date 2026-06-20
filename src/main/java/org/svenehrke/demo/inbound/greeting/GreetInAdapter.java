package org.svenehrke.demo.inbound.greeting;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.svenehrke.demo.core.greeting.HelloInPort;

/**
 * Wrapper/Adapter for `HelloInPort.hello()`.
 */
@Path("/hello")
class GreetInAdapter {

    @Inject
    HelloInPort helloInPort;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return helloInPort.hello();
    }
}
