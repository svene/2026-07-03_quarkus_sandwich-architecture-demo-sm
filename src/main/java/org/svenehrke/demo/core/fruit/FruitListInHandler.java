package org.svenehrke.demo.core.fruit;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class FruitListInHandler implements FruitListInPort {
	@Inject
	FruitListOutPort port;
	@Override
	public String getFruits() {
		return String.join(",", port.getFruits().stream().map(Fruit::name).toArray(String[]::new));
	}
}
