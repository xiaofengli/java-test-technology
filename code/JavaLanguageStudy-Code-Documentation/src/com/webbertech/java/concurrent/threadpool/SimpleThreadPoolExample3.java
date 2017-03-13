package com.webbertech.java.concurrent.threadpool;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
 /*
  *  Example 1: 
  * 
  * */
public class SimpleThreadPoolExample3 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newWorkStealingPool();
        for (int i = 0; i < 10; i++) {
            Runnable worker = new WorkerThread("" + i);
            executor.execute(worker);
        }
        executor.shutdown();
        while (!executor.isTerminated()) {}
        System.out.println("Finished all threads");
    }
}