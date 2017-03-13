package com.webbertech.java.exception;

class RestrictedClass {
	public void f() throws UnsupportedOperationException {
		System.out.println("testing");
	}
}


public class ExceptionRestriction extends RestrictedClass {
   public void f() {
	   System.out.println("testing testing");
   }
   
   public static void main(String args[]) {
	   ExceptionRestriction e = new ExceptionRestriction();
	   e.f();
   }
}


