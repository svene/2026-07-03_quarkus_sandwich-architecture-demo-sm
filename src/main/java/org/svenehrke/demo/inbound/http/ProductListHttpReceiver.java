package org.svenehrke.demo.inbound.http;

import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.svenehrke.demo.core.beverages.APIs;
import org.svenehrke.demo.core.products.ProductListAPI;

import java.util.List;

@Path("/products")
class ProductListHttpReceiver {

    @Inject
	ProductListAPI productListAPI;

    @Inject
	APIs.BeveragesListAPI beveragesAPI;

    @CheckedTemplate(basePath = "org/svenehrke/demo/products")
    static class Templates {
        public static native TemplateInstance products(List<ProductVM> products);
    }
    @GET
    public TemplateInstance products() {
        var products = productListAPI.getProducts().stream().map(it -> new ProductVM(it.id(), it.name())).toList();
        return Templates.products(products);
    }
}
