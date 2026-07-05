package org.svenehrke.demo.core.products;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.svenehrke.demo.core.beverages.BeveragesListAPI;
import org.svenehrke.demo.core.fruits.FruitListAPI;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ProductListHandler implements ProductListAPI {

	private final FruitListAPI fruitListAPI;
	private final BeveragesListAPI beveragesAPI;

	@Inject
	public ProductListHandler(FruitListAPI fruitListAPI, BeveragesListAPI beveragesAPI) {
		this.fruitListAPI = fruitListAPI;
		this.beveragesAPI = beveragesAPI;
	}

	@Override
	public List<Product> getProducts() {
		var result = new ArrayList<Product>();
		result.addAll(fruitListAPI.getFruits().stream().map(it -> new Product(it.id(), it.name())).toList());
		result.addAll(beveragesAPI.getBeverages().stream().map(it -> new Product(it.id(), it.name())).toList());
		return result;
	}
}
