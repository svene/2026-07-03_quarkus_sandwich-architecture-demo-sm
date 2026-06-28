package org.svenehrke.demo.inbound.fruits;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.svenehrke.demo.core.fruits.FruitListInPort;

/**
 * Wrapper/InboundAdapter
 */
@Path("/fruits")
class FruitListInAdapter {

    @Inject
    FruitListInPort port;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String fruits() {
        return port.getFruits();
    }
}
