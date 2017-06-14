package com.example.parallelvsfuture;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.stream.Collectors;

import com.fake.api.FakeAPI;

public class CompletableFutureExample {

	public void consumeAsync(List<FakeAPI> apis) {
		System.out.println("consume ... ");
		List<CompletableFuture<String>> futureStream = apis
				.stream()
				.map(api -> CompletableFuture.supplyAsync(() -> api
						.getSyncText(api.getClass().getName())))
						.collect(Collectors.toList());

		List<String> stringStream = futureStream.stream()
				.map(CompletableFuture::join)
				.collect(Collectors.toList());

		stringStream.stream().forEach(System.out::println);

	}
	
	public void consumeSync(List<FakeAPI> apis) {
		System.out.println("consume ... ");
 		apis.stream()
			.forEach(api-> 
			{
				try {
					api.getCompletableFutureText(api.getClass().getName()).get();
				} catch (Exception e) {
					e.printStackTrace();
				}
			});

	}
	
	public void consumeAsyncEnhanced(List<FakeAPI> apis) {
		System.out.println("consume ... ");
		List<CompletableFuture<String>> futureStream = apis
				.stream()
				.map(api -> CompletableFuture.supplyAsync(() -> api
						.getSyncText(api.getClass().getName()),executor))
						.collect(Collectors.toList());

		List<String> stringStream = futureStream.stream()
				.map(CompletableFuture::join)
				.collect(Collectors.toList());

		stringStream.stream().forEach(System.out::println);

	}
	
	private final Executor executor=
			Executors.newFixedThreadPool(Math.min(16, 32), new ThreadFactory() {
				
				@Override
				public Thread newThread(Runnable r) {
					Thread t = new Thread(r);
					t.setDaemon(true);
					return t;
				}
			});
	
}
