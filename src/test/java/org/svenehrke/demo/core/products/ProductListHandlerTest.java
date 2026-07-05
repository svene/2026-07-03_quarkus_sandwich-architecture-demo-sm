package org.svenehrke.demo.core.products;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.svenehrke.demo.core.beverages.Beverage;
import org.svenehrke.demo.core.beverages.BeveragesListAPI;
import org.svenehrke.demo.core.fruits.Fruit;
import org.svenehrke.demo.core.fruits.FruitListAPI;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ProductListHandlerTest {

	private final
	FruitListAPI fruitListAPI = Mockito.mock(FruitListAPI.class);

	private final
	BeveragesListAPI beveragesAPI = Mockito.mock(BeveragesListAPI.class);

	@Test
	void getProductList() {
		Mockito.when(fruitListAPI.getFruits()).thenReturn(List.of(new Fruit(1, "myFruit")));
		Mockito.when(beveragesAPI.getBeverages()).thenReturn(List.of(new Beverage(2, "myDrink")));
		var handler = new ProductListHandler(fruitListAPI, beveragesAPI);

		assertThat(handler.getProducts()).containsExactly(
			new Product(1, "myFruit"),
			new Product(2, "myDrink")
		);
	}
}
