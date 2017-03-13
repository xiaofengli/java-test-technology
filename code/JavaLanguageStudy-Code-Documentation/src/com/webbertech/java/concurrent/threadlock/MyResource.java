package com.webbertech.java.concurrent.threadlock;


public class MyResource {
	 
    public void doSomething(){
        //do some operation, DB read, write etc
    	System.out.println("db reading");
    }
     
    public void doLogging(){
        //logging, no need for thread safety
    	System.out.println("logging");
    }
}