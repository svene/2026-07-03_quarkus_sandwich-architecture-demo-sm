package org.svenehrke.demo.inbound.http;

import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.svenehrke.demo.core.beverages.APIs;
import org.svenehrke.demo.core.beverages.Beverage;

import java.util.List;

/**
 * Wrapper/Adapter for `BeveragesListAPI.getFruits()`.
 */
@Path("/beverages")
class BeveragesListHttpReceiver {

    @Inject
    APIs.BeveragesListAPI beveragesListAPI;

    @GET
    public TemplateInstance beverages() {
        return Templates.beverages(beveragesListAPI.getBeverages());
    }

    @CheckedTemplate(basePath = "org/svenehrke/demo/beverages")
    static class Templates {
        // parameter name must be "name"
        public static native TemplateInstance beverages(List<Beverage> beverages);
    }
}
