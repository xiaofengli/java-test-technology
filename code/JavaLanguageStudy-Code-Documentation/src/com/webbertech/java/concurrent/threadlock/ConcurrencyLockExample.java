package com.webbertech.java.concurrent.threadlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
 
public class ConcurrencyLockExample implements Runnable{
 
    private MyResource resource;
    private Lock lock;
     
    public ConcurrencyLockExample(MyResource r){
        this.resource = r;
        this.lock = new ReentrantLock();
    }
     
    @Override
    public void run() {
        try {
            if(lock.tryLock(10, TimeUnit.SECONDS)){
            resource.doSomething();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally{
            //release lock
            lock.unlock();
        }
        resource.doLogging();
    }
 
    
    public static void main(String[] args) {
    	Thread cl = new Thread(new ConcurrencyLockExample(new MyResource()));
    	cl.start();
    	
    	Thread c2 = new Thread(new ConcurrencyLockExample(new MyResource()));
    	c2.start();
    }
}