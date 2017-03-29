package com.webbertech.java.concurrent.interruptexception;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/*
 * This file is about how to properly handle InterruptedException.
 * It is normally most similar to handling other exceptions. However a little bit different.
 * 
 * Three actions to take to handle normal exceptions
 * 
 * 1/ ues throws clause to propagate the exception to upper level
 * 2/ rethrow in a catch block but you can still do some cleanup
 * 3/ log to file in catch block in step 2 as well
 * 
 * */

//Restoring the interrupted status after catching InterruptedException
public class TaskRunner implements Runnable {
    
    public TaskRunner() { 
    }
 
    public void run() { 
        try {
             
        	Thread.sleep(3000);
         }
         catch (InterruptedException e) { 
        	   System.out.println(Thread.currentThread().getName() + " " +    Thread.currentThread().isInterrupted());
        	   System.out.println(Thread.currentThread().getName() + " " +    Thread.interrupted());
               // Restore the interrupted status
               Thread.currentThread().interrupt();
               
               System.out.println(Thread.currentThread().getName() + " " +    Thread.currentThread().isInterrupted());
         } finally {
        	 System.out.println("testing");
         }
    }
    
    public static void main(String[] args) {
        Thread t = new Thread(new TaskRunner());
        t.start();
        t.interrupt();
    }
}