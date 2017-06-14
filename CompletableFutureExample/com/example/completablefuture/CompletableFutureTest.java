package com.example.completablefuture;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;

import com.fake.api.FakeAPI1;

public class CompletableFutureTest {

	public static void main(String[] args) 
			throws InterruptedException,ExecutionException {
		
		FakeAPI1 fakeAPI= new FakeAPI1();
		Long start= System.currentTimeMillis();
		List<Future<String>> apis= 
				Arrays.asList(
						fakeAPI.getAsyncText("1 at "+ System.currentTimeMillis()),
						fakeAPI.getAsyncText("2 at "+ System.currentTimeMillis()),
						fakeAPI.getAsyncText("3 at "+System.currentTimeMillis())
				);
		
		

		apis.stream().forEach(api -> {
			try{
				api.get();
			}catch(InterruptedException ex){
				ex.printStackTrace();
			}catch(ExecutionException ex){
				ex.printStackTrace();
			}
		});

		Long end= System.currentTimeMillis();
		System.out.println("CompletableFutureTest took " + (end-start) + " ms" );

	}
	

}
