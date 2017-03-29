package chapter5.section2;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Section2 {

	public static void main(String[] args) {
		//Given a list of numbers, How would you return a list of the square of each number ?
		Integer[] array={1,2,3,4,5};
		List<Integer> numbers = Arrays.asList(array);
		numbers.stream()
				.map(number->number*number)
				.collect(toList())
				.forEach(System.out::println);
		
		System.out.println("----- ----- ----- ----- -----");
		
		numbers.stream()
		.map(number->Math.multiplyExact(number, number))
		.collect(toList())
		.forEach(System.out::println);
		
		System.out.println("----- ----- ----- ----- -----");
		
		
		//Given 2 list of numbers, How can you return a list of all pairs 
		
		List<Integer> list1=Arrays.asList(new Integer[]{1,2});
		List<Integer> list2=Arrays.asList(new Integer[]{1,2,3});
		
		list1.stream().map(a-> "("+a +")" ).forEach(System.out::println);
		
		System.out.println("----- ----- ----- ----- -----");
		
		List<Object> numberArr=list1.stream().flatMap(a->  
							list2.stream().map(b-> new int[]{a,b}))
				.collect(toList());
	
		System.out.println(((int[])numberArr.get(0)));
			
		
		
	
	}
	
}
