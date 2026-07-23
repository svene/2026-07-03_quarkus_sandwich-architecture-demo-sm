package org.svenehrke.demo.core;

import java.util.List;

public interface APIs {
	interface BeveragesListAPI {
		List<Beverage> getBeverages();
	}

	interface FruitListAPI {
		List<Fruit> getFruits();
	}
}
