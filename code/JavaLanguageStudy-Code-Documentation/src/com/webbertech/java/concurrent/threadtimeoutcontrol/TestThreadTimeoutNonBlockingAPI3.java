package com.webbertech.java.concurrent.threadtimeoutcontrol;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class TestThreadTimeoutNonBlockingAPI3 {

	public static void main(String[] args) {
		
		 Runnable r = new Runnable() {
			 public void run() {
				 while(!Thread.currentThread().isInterrupted()) {}
			     try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return;
				}	 
			     if (Thread.currentThread().isInterrupted()) {
			    	 Thread.currentThread().interrupt();
			     }
			     
			     try {
						Thread.sleep(50000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			     System.out.println("dont do this");
			 }
			 
		 };

	    ExecutorService executor = Executors.newSingleThreadExecutor();

	    Future<?> future = executor.submit(r);
	    try {
	        future.get(3, TimeUnit.SECONDS);
	    } catch (TimeoutException e) {
	        boolean c = future.cancel(true);
	        System.out.println("Timeout " + c);
	    } catch (InterruptedException | ExecutionException e) {
	        System.out.println("interrupted");
	    }
	    System.out.println("END");

	}
}
