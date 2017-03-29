package chapter5.section6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.OptionalInt;

import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.List;
import java.util.stream.IntStream;

public class Section6Test {

	List<Comedian> comedians;
	@Before
	public void setup(){
		comedians=new ArrayList<Comedian>();
		comedians.add(new Comedian("Aziz Ansari", 33,17000000 ));
		comedians.add(new Comedian("Jo Koy", 52,1000000 ));
		comedians.add(new Comedian("Gabriel Iglesias", 40,10000000 ));
		comedians.add(new Comedian("Russell Peters", 46,21000000  ));
	}
	
	@Test
	public void test1(){
		/* 
		 	(1) The problem with this approach is the boxing cost
				Behind the scenes each Integer needs to be unboxed 
				to a primitive before performing the summation
			
			(2) reduce generates a Stream<T> and that interface does not have 
				sum method 
		*/
		int sum = comedians
				.stream()
				.map(Comedian::getAge)
				.reduce(0, Integer::sum);
		
		assertThat(171, equalTo(sum));
		
	}
	
	@Test
	public void test2(){
		
		OptionalInt max=comedians
				.stream()
				.mapToInt(Comedian::getSalary)
				.max();
		assertThat(21000000, equalTo(max.getAsInt()));
		
		
		
		OptionalInt min=comedians
				.stream()
				.mapToInt(Comedian::getSalary)
				.min();
		assertThat(1000000, equalTo(min.getAsInt()));
		
	}
	
	@Test
	public void test3(){
		IntStream intStrem=IntStream
				.rangeClosed(1, 100)
				.filter(i->i%2==0);
		assertThat(50L, equalTo(intStrem.count()));
		
	}
	
	
	

}
