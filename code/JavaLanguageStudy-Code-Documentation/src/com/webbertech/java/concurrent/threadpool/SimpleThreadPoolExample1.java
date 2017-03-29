package com.webbertech.java.concurrent.threadpool;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
 /*
  *  Example 1: 
  * 
  * */
public class SimpleThreadPoolExample1 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        for (int i = 0; i < 10; i++) {
            Thread worker = new Thread(new WorkerThread("" + i));
            worker.setDaemon(true);
            executor.execute(worker);
        }
        executor.shutdown();
        while (!executor.isTerminated()) {}
        System.out.println("Finished all threads");
    }
}