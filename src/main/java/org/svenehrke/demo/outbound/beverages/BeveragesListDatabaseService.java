package org.svenehrke.demo.outbound.beverages;

import jakarta.enterprise.context.ApplicationScoped;
import org.svenehrke.demo.core.beverages.BeveragesListSPI;
import org.svenehrke.demo.outside.backend.beverages.BeveragesDB;

import java.util.List;

@ApplicationScoped
class BeveragesListDatabaseService implements BeveragesListSPI {

	@Override
	public List<Integer> getBeverages() {
		return new BeveragesDB().getBeverages().stream()
			.map(it -> codeToId(it.code()))
			.toList();
	}

	/**
	 * This method of the Adapter has the knowledge of how to map a
	 * persistent-code to a domain-id
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
