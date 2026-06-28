package org.svenehrke.demo.outbound.fruits;

import jakarta.enterprise.context.ApplicationScoped;
import org.svenehrke.demo.core.fruits.Fruit;
import org.svenehrke.demo.core.fruits.FruitIdToFruitOutPort;

import java.util.Map;

@ApplicationScoped
class FruitIdToFruitOutAdapter implements FruitIdToFruitOutPort {

	@Override
	public Fruit getFruitById(int id) {
		return fruits.get(id);
	}

	private Map<Integer, Fruit> fruits = Map.of(
		1, new Fruit(1, "Apple"),
		2, new Fruit(2, "Banana"),
		3, new Fruit(3, "Orange")
	);
}
