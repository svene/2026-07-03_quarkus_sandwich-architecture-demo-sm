package org.svenehrke.demo.outside.backend;

import java.util.List;

public class BeveragesDB {
	public record PersistedFruit(String code, String name){}

	public List<PersistedFruit> getBeverages() {
		return List.of(
			new PersistedFruit("ap", "Apple"),
			new PersistedFruit("ba", "Banana"),
			new PersistedFruit("or", "Orange")
		);
	}
}
