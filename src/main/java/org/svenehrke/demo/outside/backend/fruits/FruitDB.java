package org.svenehrke.demo.outside.backend.fruits;

import java.util.List;

public class FruitDB {
	public record PersistedFruit(String code, String name){}

	public List<PersistedFruit> getFruits() {
		return List.of(
			new PersistedFruit("ap", "Apple"),
			new PersistedFruit("ba", "Banana"),
			new PersistedFruit("or", "Orange")
		);
	}
}
