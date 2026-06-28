package org.svenehrke.demo.core.fruits;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
class FruitListInHandler implements FruitListInPort {

	private final FruitListOutPort port;
	private final FruitIdToFruitOutPort fruitIdToFruitOutPort;

	@Inject
	public FruitListInHandler(FruitListOutPort port, FruitIdToFruitOutPort fruitIdToFruitOutPort) {
		this.port = port;
		this.fruitIdToFruitOutPort = fruitIdToFruitOutPort;
	}

	@Override
	public List<Fruit> getFruits() {
		return port.getFruitIds().stream().map(fruitIdToFruitOutPort::getFruitById).toList();
	}
}
