package com.webbertech.java.exception;
class MyExceptionA extends Exception {
	private static final long serialVersionUID = 4429130920389817461L;}

class MyExceptionB extends Exception {
	private static final long serialVersionUID = 7408784570692964269L;}

class A {
	public void f() throws MyExceptionA {} 
}

class B extends A {
	
	//this is illegal, cant throw a different exception
	//in an overrided method
	//public void f() throws MyExceptionB {}
		
	//this is legal
	public void f() throws MyExceptionA {}
}

public class ExceptionInOverride {
  public static void main(String args[]) {}
}
