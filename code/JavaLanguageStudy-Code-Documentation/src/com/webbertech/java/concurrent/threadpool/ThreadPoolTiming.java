package com.webbertech.java.concurrent.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MyThread implements Runnable {
	  //this is a var stored in the objects
	  long requestTime;
	  
	  MyThread(long reqTime) {
		  requestTime = reqTime;
	  }
	  
	  public void run() {
		  if((ThreadPoolTiming.lastUpdateTime - requestTime)> ThreadPoolTiming.LIMIT_UPDATE_RATE) {
			  System.out.println("socket update ######");
			  // real meat
		  }
	  }
}


public class ThreadPoolTiming {
	static long lastUpdateTime = System.currentTimeMillis();
	static int LIMIT_UPDATE_RATE = 2000; // 2 millisecs
	
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(1);
           
        executor.execute(new MyThread(System.currentTimeMillis()));
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        System.out.println("Finished all threads");
    }
}