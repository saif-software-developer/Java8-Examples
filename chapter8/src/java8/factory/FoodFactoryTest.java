package java8.factory;

import static org.junit.Assert.*;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;

public class FoodFactoryTest {

	Food food;

	@Test
	public void test() {
		food= FoodFactory.cookFoodForMe("Falafel");
		assertThat(new Falafel(),equalTo(food));
		
		food= FoodFactory.cookFoodForMe("Humus");
		assertThat(new Humus(),equalTo(food));
		
		food= FoodFactory.cookFoodForMe("Mansaf");
		assertThat(new Mansaf(),equalTo(food));
	}

}
