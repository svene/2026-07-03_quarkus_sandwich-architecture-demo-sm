package org.svenehrke.demo.outbound.fruitservice.memory;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.svenehrke.demo.core.Fruit;
import org.svenehrke.demo.core.FruitListInPort2;
import org.svenehrke.demo.core.FruitListOutPort;

import java.util.List;

@ApplicationScoped
public class MemoryFruitService implements FruitListOutPort {
	@Inject
	FruitListInPort2 fruitListInPort2;

	@Override
	public List<Fruit> getFruits() {
		return new FruitDB().getFruits().stream()
			.map(it -> codeToId(it.code()))
			.map(it -> fruitListInPort2.getFruitById(it)) // NOTE: this adapter calls a domain-service via port (I have not seen this yet in the HexArc-Blogs)
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
