package chapter5.section1;

import java.util.ArrayList;
import java.util.List;
import static java.util.stream.Collectors.toList;

public class Section1 {

	public static void main(String[] args) {
		
		List<Car> cars = new ArrayList<Car>();
		cars.add(new Car("Ford","F-15",2017));
		cars.add(new Car("Ford","F-20",2017));
		cars.add(new Car("Acura","NSX",2016));
		cars.add(new Car("Lexus","RC",2017));
		cars.add(new Car("Toyota","Camery",2017));
		
		for(Car car: cars){
			if(car.getMake().equals("Ford")){
				System.out.println(car.getMake());
			}
		}
		
		//Mapping 
		List<String> carMakes=cars.stream().map(Car::getMake).collect(toList());
		for(String make:carMakes){
			System.out.println(make);
		}
		cars.stream().map(Car::getMake).collect(toList())
				.forEach(System.out::println);
		
		//Filtering with predicate 
		cars.stream()
		.filter(c->c.getMake().equals("Ford"))
		.map(Car::getMake)
		.forEach(System.out::println);
		
		//Filtering unique elements 
		cars.stream()
		.filter(c->c.getMake().equals("Ford"))
		.map(Car::getMake)
		.distinct()
		.forEach(System.out::println);

		
		//Truncating 
		cars.stream()
		.map(Car::getMake)
		.distinct().limit(2)
		.collect(toList())
		.forEach(System.out::println);
		
		//Skipping 
		cars.stream()
		.map(Car::getMake)
		.distinct()
		.skip(2)
		.limit(1)
		.collect(toList())
		.forEach(System.out::println);
		
		
		
	}

}
