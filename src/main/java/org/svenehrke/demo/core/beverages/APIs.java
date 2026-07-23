package org.svenehrke.demo.core.beverages;

import org.svenehrke.demo.core.fruits.Fruit;

import java.util.List;

public interface APIs {
	interface BeveragesListAPI {
		List<Beverage> getBeverages();
	}

	interface FruitListAPI {
		List<Fruit> getFruits();
	}
}
