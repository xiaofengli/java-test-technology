package com.webbertech.java.concurrent.futuretask;

//http://www.journaldev.com/1650/java-futuretask-example-program
	
import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {
 
    private long waitTime;
     
    public MyCallable(int timeInMillis){
        this.waitTime=timeInMillis;
    }
    
    @Override
    public String call() throws Exception {
        Thread.sleep(waitTime);
        //return the thread name executing this callable task
        return Thread.currentThread().getName();
    }
 
}
