package org.svenehrke.demo.inbound.fruits;

import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.svenehrke.demo.core.fruits.Fruit;
import org.svenehrke.demo.core.fruits.FruitListAPI;

import java.util.List;

/**
 * Wrapper/InboundAdapter
 */
@Path("/fruits")
class FruitsListHttpListener {

    @Inject
	FruitListAPI port;

    @GET
    public TemplateInstance fruits() {
        return Templates.fruits(port.getFruits());
    }

    @CheckedTemplate(basePath = "org/svenehrke/demo/fruits")
    static class Templates {
        // parameter name must be "name"
        public static native TemplateInstance fruits(List<Fruit> fruits);
    }

}
