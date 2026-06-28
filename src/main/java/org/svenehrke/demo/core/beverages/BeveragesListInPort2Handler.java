package org.svenehrke.demo.core.beverages;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.Map;

@ApplicationScoped
class BeveragesListInPort2Handler implements BeveragesListInPort2 {

	@Override
	public Beverage getFruitById(int id) {
		return items.get(id);
	}

	private Map<Integer, Beverage> items = Map.of(
		1, new Beverage(1, "Water"),
		2, new Beverage(2, "Beer"),
		3, new Beverage(2, "Orange Juice")
	);
}
