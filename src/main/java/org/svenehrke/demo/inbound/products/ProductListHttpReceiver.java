package org.svenehrke.demo.inbound.products;

import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.svenehrke.demo.core.beverages.BeveragesListAPI;
import org.svenehrke.demo.core.fruits.FruitListAPI;

import java.util.ArrayList;
import java.util.List;

@Path("/products")
class ProductListHttpReceiver {

    @Inject
    FruitListAPI fruitListAPI;

    @Inject
	BeveragesListAPI beveragesAPI;

    @CheckedTemplate(basePath = "org/svenehrke/demo/products")
    static class Templates {
        public static native TemplateInstance products(List<ProductVM> products);
    }
    @GET
    public TemplateInstance products() {
        var products = new ArrayList<ProductVM>();
        products.addAll(fruitListAPI.getFruits().stream().map(it -> new ProductVM(it.id(), it.name())).toList());
        products.addAll(beveragesAPI.getBeverages().stream().map(it -> new ProductVM(it.id(), it.name())).toList());
        return Templates.products(products);
    }
}
