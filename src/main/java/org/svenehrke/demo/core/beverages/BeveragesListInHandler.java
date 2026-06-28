package org.svenehrke.demo.core.beverages;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
class BeveragesListInHandler implements BeveragesListInPort {
	@Inject
	BeveragesListOutPort port;
	@Override
	public List<Beverage> getBeverages() {
		return port.getBeverages();
	}
}
