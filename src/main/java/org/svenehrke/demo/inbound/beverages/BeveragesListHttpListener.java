package org.svenehrke.demo.inbound.beverages;

import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.svenehrke.demo.core.beverages.Beverage;
import org.svenehrke.demo.core.beverages.BeveragesListAPI;

import java.util.List;

/**
 * Wrapper/Adapter for `BeveragesListAPI.getFruits()`.
 */
@Path("/beverages")
class BeveragesListHttpListener {

    @Inject
	BeveragesListAPI port;

    @GET
    public TemplateInstance beverages() {
        return Templates.beverages(port.getBeverages());
    }

    @CheckedTemplate(basePath = "org/svenehrke/demo/beverages")
    static class Templates {
        // parameter name must be "name"
        public static native TemplateInstance beverages(List<Beverage> beverages);
    }
}
