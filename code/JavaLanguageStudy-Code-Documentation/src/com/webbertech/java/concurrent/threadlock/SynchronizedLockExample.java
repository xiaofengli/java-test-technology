package com.webbertech.java.concurrent.threadlock;


//ref: http://www.journaldev.com/2377/java-lock-example-and-concurrency-lock-vs-synchronized


public class SynchronizedLockExample implements Runnable{
	 
    private MyResource  resource;
     
    public SynchronizedLockExample(MyResource r){
        this.resource = r;
    }
     
    @Override
    public void run() {
        synchronized (resource) {
            resource.doSomething();
        }
        resource.doLogging();
    }
    
    
    public static void main(String[] args) {
    	Thread cl = new Thread(new SynchronizedLockExample(new MyResource()));
    	cl.start();
    	
    	Thread c2 = new Thread(new SynchronizedLockExample(new MyResource()));
    	c2.start();
    }
}