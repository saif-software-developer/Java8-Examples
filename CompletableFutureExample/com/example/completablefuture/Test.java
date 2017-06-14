package com.example.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Test {

	public void test() 
			throws InterruptedException, ExecutionException{
			System.out.println("In test() ");
			CompletableFuture cf=CompletableFuture.supplyAsync(this::sendMsg)  
							 .thenAccept(this::yoyo);
			System.out.println("is Done ? "+ cf.isDone());
			System.out.println("is Done ? "+ cf.get());
	}
	
	public String sendMsg() {
		try {
			Thread.sleep(1000L);
			System.out.println("sendMsg ");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "Yo Yo";
	}
	
	public void yoyo(String msg){
		System.out.println("Yo Yo ");
	}
	
}
