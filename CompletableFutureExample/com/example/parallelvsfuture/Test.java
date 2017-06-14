package com.example.parallelvsfuture;

import java.util.ArrayList;
import java.util.List;

import com.fake.api.FakeAPI;
import com.fake.api.FakeAPI1;

public class Test {

	public static void main(String[] args) {
		
		Long start;
		Long end;
		
		System.out.println("Available processors" + Runtime.getRuntime().availableProcessors());
		
		List<FakeAPI> apis = new ArrayList<>();
		
		apis.add(new FakeAPI1());
		apis.add(new FakeAPI1());
		apis.add(new FakeAPI1());
		apis.add(new FakeAPI1());
		apis.add(new FakeAPI1());
		apis.add(new FakeAPI1());
		apis.add(new FakeAPI1());
		apis.add(new FakeAPI1());
		
		apis.add(new FakeAPI1());
		apis.add(new FakeAPI1());
		apis.add(new FakeAPI1());
		apis.add(new FakeAPI1());
		apis.add(new FakeAPI1());
		apis.add(new FakeAPI1());
		apis.add(new FakeAPI1());
		apis.add(new FakeAPI1());
		
		
		CompletableFutureExample completableFutureExample= new CompletableFutureExample();
		ParallelExample parallelExample=new ParallelExample();
		
		//Test sync CompletableFuture 
//		start= System.currentTimeMillis();
//		completableFutureExample.consumeSync(apis);
//		end= System.currentTimeMillis();
//		System.out.println("sync CompletableFuture  took " + (end-start) + " ms" );
//		System.out.println("--------------- " );
		
	
		
		//Test parallel 
		start= System.currentTimeMillis();
		parallelExample.consume(apis);
		end= System.currentTimeMillis();
		System.out.println("parallel stream took " + (end-start) + " ms" );
		System.out.println("--------------- " );
		
		//Test async CompletableFuture 
//		start= System.currentTimeMillis();
//		completableFutureExample.consumeAsync(apis);
//		end= System.currentTimeMillis();
//		System.out.println("async CompletableFuture  took " + (end-start) + " ms" );
//		System.out.println("--------------- " );
		
		//Test async CompletableFuture 
		start= System.currentTimeMillis();
		completableFutureExample.consumeAsyncEnhanced(apis);
		end= System.currentTimeMillis();
		System.out.println("async CompletableFuture  took " + (end-start) + " ms" );
		System.out.println("--------------- " );
				
	}

}
