package chapter5.section3;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;

import chapter5.section1.Car;

public class Section3Test {

	List<Car> cars;
	
	@Before
	public void setUp(){
		cars = new ArrayList<Car>();
		cars.add(new Car("Ford","F-15",2017));
		cars.add(new Car("Ford","F-20",2017));
		cars.add(new Car("Acura","NSX",2016));
		cars.add(new Car("Lexus","RC",2017));
		cars.add(new Car("Toyota","Camery",2017));
		cars.add(new Car("Saif","Bro",2015));
		//cars.add(new Car("Yo","Yo",2018));
	}
	
	
	//Should find any 2017 car
	@Test
	public void shouldFindA2017Car(){
		assertTrue(cars.stream().anyMatch(c->c.getYear()>2016));
	}
	
	//All cars should be > 2015
	@Test
	public void allCarsShouldbeGT2017(){
		assertTrue(cars.stream().allMatch(c->c.getYear()>=2015));
	}
	
	
	//Find any car produced after 2017 
	@Test
	public void shouldReturnFordCar(){
		Optional<Car> car=cars.parallelStream()
				.filter(c->c.getMake().equals("Ford"))
				.findAny();
		
		assertTrue(car.isPresent());
		assertEquals("Ford", car.get().getMake());
	}
	
	
	//Find first car produced after 2017 
	
	@Test
	public void findFirstTest(){
		
		Optional<Car> car=cars.stream().findFirst();
		assertTrue(car.isPresent());
		
		car=cars.stream().filter(c->c.getYear()<2016).findFirst();
		assertTrue(car.isPresent());
		
	}
	
	//Make sure non of the cars are 2019
	@Test
	public void noneMatch(){
		assertTrue(cars.stream()
				.noneMatch(c->c.getYear().equals(2019)));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	
//	@Test
//	public void shouldFindA2017Car() {
//		assertTrue(cars.stream()
//						.anyMatch(car->car.getYear()>2016)
//			);
//	}
//	
//	@Test
//	public void allCarsMadeShouldBeGreaterThan2015(){
//		assertTrue(cars.stream()
//						.allMatch(car->car.getYear()>2015)
//					);
//	}
//	
//	@Test
//	public void findAnyTest(){
//		Optional<Car> car=cars.stream().findAny();
//		assertTrue(car.isPresent());
//		
//		car=cars.stream().filter(c->c.getYear()>2017).findAny();
//		assertFalse(car.isPresent());		
//	}
//	
//	@Test
//	public void findFirstTest(){
//		
//		Optional<Car> car=cars.stream().findFirst();
//		assertTrue(car.isPresent());
//		
//		car=cars.stream().filter(c->c.getYear()<2016).findFirst();
//		assertTrue(car.isPresent());
//		
//	}
//	
	

}
