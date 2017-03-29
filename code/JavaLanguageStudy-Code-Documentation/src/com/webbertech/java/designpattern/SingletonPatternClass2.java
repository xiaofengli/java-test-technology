package com.webbertech.java.designpattern;

//This is called static factory method
//becaues static variable is initialized before the class constructor is being called.

public class SingletonPatternClass2 {
	private static final SingletonPatternClass2 INSTANCE = new SingletonPatternClass2();
	
	private SingletonPatternClass2() {
		System.out.println("I am here");
	}
	
	public static SingletonPatternClass2 getSingleton() {
		return INSTANCE;
	}
	
	public static void main(String[] args) {
		SingletonPatternClass2 ins1= SingletonPatternClass2.getSingleton();
		System.out.println("testing me");
		SingletonPatternClass2 ins2= SingletonPatternClass2.getSingleton();
		System.out.println(ins1==ins2);
	}
}