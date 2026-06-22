package org.svenehrke.demo.outbound.fruit;

import jakarta.enterprise.context.ApplicationScoped;
import org.svenehrke.demo.core.fruit.FruitListOutPort;

import java.util.List;

@ApplicationScoped
public class MemoryFruitService implements FruitListOutPort {
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
