package org.svenehrke.demo.core;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Map;

@ApplicationScoped
public class BeveragesListHandler implements APIs.BeveragesListAPI {

	public interface BeveragesListSPI {
		List<Integer> getBeverages();
	}
	private final BeveragesListSPI beveragesListSPI;

	@Inject
	public BeveragesListHandler(BeveragesListSPI beveragesListSPI) {
		this.beveragesListSPI = beveragesListSPI;
	}

	@Override
	public List<Beverage> getBeverages() {
		return beveragesListSPI.getBeverages().stream().map(beverages::get).toList();
	}

	private final Map<Integer, Beverage> beverages = Map.of(
		// TODO: support i18n: "labels.water"
		//  does it makes sense ?
		//  are translations not rather provided by DB ?
		//  -> static translations for labels, dynamic translation for things coming from DB rather in DB
		1, new Beverage(1, "Water"),
		2, new Beverage(2, "Beer"),
		3, new Beverage(2, "Orange Juice")
	);
}
