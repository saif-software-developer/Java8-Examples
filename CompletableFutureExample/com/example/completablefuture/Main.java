package com.example.completablefuture;

import java.util.concurrent.ExecutionException;

public class Main {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Test test = new Test();
		System.out.println("About to call test ... ");
		test.test();
		System.out.println("Called test");

	}

}
