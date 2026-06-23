package org.svenehrke.demo.core.fruit;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

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
	public String getFruits() {
		return String.join(",", port.getFruitIds().stream().map(it -> fruitIdToFruitOutPort.getFruitById(it).name()).toArray(String[]::new));
	}
}
