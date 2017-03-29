package com.webbertech.java.exception;
//this will be just a normal class with overloading constructors and methods.


public class ExceptionMatch {
   
	//the following error was right
	class MyException extends Exception {}
	
	public static void main(String[] args) {
    	someClass c = new someClass();
    	/*  legal
    	try {
    		c.setName(null);
    	} catch (MyException e) {
    		e.printStackTrace();
    	} catch (Exception e) {
    	}
    	*/
    	try {
    		c.setName(null);
    	} catch (Exception e) {
    	} catch (MyException e) {  //this is not legal
    		e.printStackTrace();
    	} 
    }
}