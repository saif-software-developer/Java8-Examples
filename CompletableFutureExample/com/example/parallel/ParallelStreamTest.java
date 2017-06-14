package com.example.parallel;

import java.util.Arrays;
import java.util.List;

import com.fake.api.FakeAPI;
import com.fake.api.FakeAPI1;
import com.fake.api.FakeAPI2;
import com.fake.api.FakeAPI3;

public class ParallelStreamTest {

	public static void main(String[] args) {
		Long start= System.currentTimeMillis();
		List<FakeAPI> apis= Arrays.asList(
				new FakeAPI1(),
				new FakeAPI2(),
				new FakeAPI3());
		
		apis.parallelStream()
			.forEach(it->it.getSyncText(it.getClass().getName()+ " at "+ System.currentTimeMillis() ));
		Long end= System.currentTimeMillis();
		
		System.out.println("ParallelStreamTest took " + (end-start) + " ms" );
	}

}
