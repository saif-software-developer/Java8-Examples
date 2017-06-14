package com.example.parallelvsfuture;

import java.util.List;

import com.fake.api.FakeAPI;

public class ParallelExample {

	public void consume(List<FakeAPI> apis){
		apis.parallelStream()
			.forEach(api-> api.getSyncText(api.getClass().getName()));
	}
	
}
