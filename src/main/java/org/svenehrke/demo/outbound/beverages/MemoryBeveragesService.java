package org.svenehrke.demo.outbound.beverages;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.svenehrke.demo.core.beverages.Beverage;
import org.svenehrke.demo.core.beverages.BeveragesListInPort2;
import org.svenehrke.demo.core.beverages.BeveragesListOutPort;
import org.svenehrke.demo.outside.backend.beverages.BeveragesDB;

import java.util.List;

@ApplicationScoped
class MemoryBeveragesService implements BeveragesListOutPort {
	@Inject
	BeveragesListInPort2 inPort2;

	@Override
	public List<Beverage> getBeverages() {
		return new BeveragesDB().getBeverages().stream()
			.map(it -> codeToId(it.code()))
			.map(it -> inPort2.getFruitById(it)) // NOTE: this adapter calls a domain-service via port (I have not seen this yet in the HexArc-Blogs)
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
