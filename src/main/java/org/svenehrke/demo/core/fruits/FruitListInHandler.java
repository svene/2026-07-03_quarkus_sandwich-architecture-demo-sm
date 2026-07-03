package org.svenehrke.demo.core.fruits;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
class FruitListInHandler implements FruitListInPort {

	private final FruitListOutPort port;

	// id -> Fruit mapping. Implemented by an out-adapter in this case, but for this case it could just as well be done in the core only
	// TODO: use case which might justify an adapter: translations for the fruit names which might need a lookup in another DB
	private final FruitIdToFruitOutPort fruitIdToFruitOutPort;

	@Inject
	public FruitListInHandler(FruitListOutPort port, FruitIdToFruitOutPort fruitIdToFruitOutPort) {
		this.port = port;
		this.fruitIdToFruitOutPort = fruitIdToFruitOutPort;
	}

	@Override
	public List<Fruit> getFruits() {
		List<Integer> fruitIds = port.getFruitIds();
		return fruitIds.stream().map(fruitIdToFruitOutPort::getFruitById).toList();
	}
}
