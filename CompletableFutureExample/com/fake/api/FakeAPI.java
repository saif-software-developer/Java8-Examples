package com.fake.api;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public interface  FakeAPI {
	
	public void consume();
	
	default public Future<String> getAsyncText(String pid){
		System.out.println("default getRandomText() @ FakeAPI was called by "+ pid);
		CompletableFuture<String> futureString= new CompletableFuture<String>();
		new Thread( ()-> {
			try{
				String stringValue=getText(pid);
				futureString.complete(stringValue);
			}catch(Exception ex){
				futureString.completeExceptionally(ex);
			}
		}).start();
		
		return futureString;
	}
	
	default public Future<String> getCompletableFutureText(String pid){
		System.out.println("default getCompletableFutureText() @ FakeAPI was called by "+ pid);
		CompletableFuture<String> futureString= new CompletableFuture<String>();
		String stringValue=getText(pid);
		futureString.complete(stringValue);
		
		return futureString;
	}
	
	default public String getSyncText(String pid){
		return getText(pid);
	}
	
	default public String getText(String pid){
		System.out.println("default getText() @ FakeAPI was called by "+ pid );
		delay();
		return "";
	}
	
	default void delay(){
		try{
			Thread.sleep(1000L);
		}catch(InterruptedException e){
			System.out.println("Eat it silently");
		}
	}

}
