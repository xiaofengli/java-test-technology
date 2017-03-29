package com.webbertech.java.exception;
//this will be just a normal class with overloading constructors and methods.

class MyException extends Exception {
	
	MyException() {
		System.out.println("caught in MyException");
	}
}

interface MyInterface {
    void f() throws MyException;
}

class someClass {
	void setName(String name) throws MyException {
		if(name == null) 
			throw new MyException();
	}

}

public class MyDemo {
    /*
	public static void main(String[] args) throws MyException {
    	someClass c = new someClass();
    	c.setName(null);
    }
    */
	public static void main(String[] args) {
    	someClass c = new someClass();
    	try {
    		c.setName(null);
    	} catch (MyException e) {
    		e.printStackTrace();
    	}
    }
}
