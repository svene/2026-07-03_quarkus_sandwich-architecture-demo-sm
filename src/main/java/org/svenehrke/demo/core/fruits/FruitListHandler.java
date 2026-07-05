package org.svenehrke.demo.core.fruits;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Map;

@ApplicationScoped
public class FruitListHandler implements FruitListAPI {

	private final FruitListSPI port;

	@Inject
	public FruitListHandler(FruitListSPI port) {
		this.port = port;
	}

	@Override
	public List<Fruit> getFruits() {
		List<Integer> fruitIds = port.getFruitIds();
		return fruitIds.stream().map(fruits::get).toList();
	}

	private final Map<Integer, Fruit> fruits = Map.of(
		1, new Fruit(1, "Apple"),
		2, new Fruit(2, "Banana"),
		3, new Fruit(3, "Orange")
	);
}
