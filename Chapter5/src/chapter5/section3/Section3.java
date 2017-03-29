package chapter5.section3;

import java.util.ArrayList;
import java.util.List;

import chapter5.section1.Car;

public class Section3 {

	public static void main(String args[]){
		
		List<Car> cars = new ArrayList<Car>();
		cars.add(new Car("Ford","F-15",2017));
		cars.add(new Car("Ford","F-20",2017));
		cars.add(new Car("Acura","NSX",2016));
		cars.add(new Car("Lexus","RC",2017));
		cars.add(new Car("Toyota","Camery",2017));
		
		
		boolean any2017Car=cars.stream().anyMatch(car->car.getYear()>2016);
		boolean allFord=cars.stream().allMatch(car->car.getMake().equals("Ford"));
		
		
	}
}
