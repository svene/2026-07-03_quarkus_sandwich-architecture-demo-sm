package org.svenehrke.demo.core;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.Map;

@ApplicationScoped
public class FruitListInPort2Handler implements FruitListInPort2 {

	@Override
	public Fruit getFruitById(int id) {
		return fruits.get(id);
	}

	private Map<Integer, Fruit> fruits = Map.of(
		1, new Fruit(1, "Apple"),
		2, new Fruit(2, "Banana"),
		3, new Fruit(2, "Orange")
	);
}
