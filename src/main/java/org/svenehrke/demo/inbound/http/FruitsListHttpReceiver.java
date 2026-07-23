package org.svenehrke.demo.inbound.http;

import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.svenehrke.demo.core.APIs;
import org.svenehrke.demo.core.Fruit;

import java.util.List;

/**
 * Wrapper/InboundAdapter
 */
@Path("/fruits")
class FruitsListHttpReceiver {

    @Inject
	APIs.FruitListAPI fruitListAPI;

    @GET
    public TemplateInstance fruits() {
        return Templates.fruits(fruitListAPI.getFruits());
    }

    @CheckedTemplate(basePath = "org/svenehrke/demo/fruits")
    static class Templates {
        // parameter name must be "name"
        public static native TemplateInstance fruits(List<Fruit> fruits);
    }

}
