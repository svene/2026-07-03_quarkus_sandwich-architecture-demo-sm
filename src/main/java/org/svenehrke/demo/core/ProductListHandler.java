package org.svenehrke.demo.core;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ProductListHandler implements ProductListAPI {

	private final FruitListHandler fruitListHandler;
	private final BeveragesListHandler beveragesListHandler;

	@Inject
	public ProductListHandler(
		FruitListHandler fruitListHandler,
		BeveragesListHandler beveragesListHandler
	) {
		this.fruitListHandler = fruitListHandler;
		this.beveragesListHandler = beveragesListHandler;
	}

	@Override
	public List<Product> getProducts() {
		var result = new ArrayList<Product>();
		result.addAll(fruitListHandler.getFruits().stream().map(it -> new Product(it.id(), it.name())).toList());
		result.addAll(beveragesListHandler.getBeverages().stream().map(it -> new Product(it.id(), it.name())).toList());
		return result;
	}
}
