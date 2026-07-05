package org.svenehrke.demo.core.products;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.svenehrke.demo.core.beverages.BeveragesListHandler;
import org.svenehrke.demo.core.beverages.BeveragesListSPI;
import org.svenehrke.demo.core.fruits.FruitListHandler;
import org.svenehrke.demo.core.fruits.FruitListSPI;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ProductListHandlerTest {

	private final
	FruitListSPI fruitListSPI = Mockito.mock(FruitListSPI.class);

	private final
	BeveragesListSPI beveragesSPI = Mockito.mock(BeveragesListSPI.class);

	@Test
	void getProductList() {
		Mockito.when(fruitListSPI.getFruitIds()).thenReturn(List.of(1));
		Mockito.when(beveragesSPI.getBeverages()).thenReturn(List.of(2));
		var handler = new ProductListHandler(new FruitListHandler(fruitListSPI), new BeveragesListHandler(beveragesSPI));

		assertThat(handler.getProducts()).containsExactly(
			new Product(1, "Apple"),
			new Product(2, "Beer")
		);
	}
}
