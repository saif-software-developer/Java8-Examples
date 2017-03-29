package chapter5.section4;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hamcrest.core.IsEqual;
import org.junit.Before;
import org.junit.Test;

import chapter5.section1.Car;
import static org.hamcrest.CoreMatchers.*;

public class ReduceTest {

	
	List<Car> cars;
	
	@Before
	public void setUp(){
		cars = new ArrayList<Car>();
		cars.add(new Car("Ford","F-15",2017,1000));
		cars.add(new Car("Ford","F-20",2017,1000));
		cars.add(new Car("Acura","NSX",2016,2000));
		cars.add(new Car("Lexus","RC",2017,1000));
		cars.add(new Car("Toyota","Camery",2017,900));
		cars.add(new Car("Saif","Bro",2015,200));
		//cars.add(new Car("Yo","Yo",2018,250));
	}
	
	@Test
	public void shouldFindCorrectCarsSummationPrice(){
		int sum=0;
		for(Car car:cars){
			sum+=car.getPrice();
		}
		assertThat(6100, equalTo(sum));
	}
	
	@Test
	public void testReduceSum1(){
		Optional<Integer> sum=cars
				.stream()
				.map(c->c.getPrice())
				.reduce((a,b)->a+b);
		
		assertThat(6100, equalTo(sum.get()));
	}
	
	@Test
	public void testReduceSum2(){
		Optional<Integer> sum=cars
				.stream()
				.map(c->c.getPrice())
				.reduce(Integer::sum);
		assertThat(6100, equalTo(sum.get()));
	}
	
	@Test
	public void maxShouldBe2000(){
		Optional<Integer> max=cars
				.stream()
				.map(Car::getPrice)
				.reduce(Integer::max);
		assertThat(2000, equalTo(max.get()));
	}
	
	@Test
	public void minShouldBe100(){
		Optional<Integer> max=cars
				.stream()
				.map(Car::getPrice)
				.reduce(Integer::min);
		assertThat(200, equalTo(max.get()));
	}
	

}
