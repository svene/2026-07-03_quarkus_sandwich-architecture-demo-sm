package org.svenehrke.demo.outbound.fruits;

import jakarta.enterprise.context.ApplicationScoped;
import org.svenehrke.demo.core.fruits.FruitListHandler;
import org.svenehrke.demo.outside.backend.fruits.FruitDB;

import java.util.List;

@ApplicationScoped
class FruitsListDatabaseService implements FruitListHandler.FruitListSPI {
	@Override
	public List<Integer> getFruitIds() {
		return new FruitDB().getFruits().stream()
			.map(it -> codeToId(it.code()))
			.toList();
	}

	/**
	 * This method of the Adapter has the knowledge of how to map a
	 * PersistentFruit to a domain-Fruit
	 */
	private int codeToId(String code) {
		return switch (code) {
			case "ap" -> 1;
			case "ba" -> 2;
			case "or" -> 3;
			default -> 1;
		};
	}

}
