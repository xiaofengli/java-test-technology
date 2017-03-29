package com.webbertech.java.designpattern;
// There is another way that I use to implement singleton, this is a bad example.
public class SingletonPatternClass4 {

	private static Object classLock = new Object();
	private static SingletonPatternClass4 instance;

	private SingletonPatternClass4() {
		System.out.println("do something in the constructor");
	}

	public static SingletonPatternClass4 getInstance() {
			synchronized (classLock) {
				if (instance == null) {
					 instance=new SingletonPatternClass4();
				}
			}
	
		return instance;
	}

	class TestThread implements Runnable {
		SingletonPatternClass4 test_instance;
		public void run() {
			test_instance = SingletonPatternClass4.getInstance();	
		}
		
		public SingletonPatternClass4 getResult() {
			return test_instance;
		}
	}
	
	public static void main(String[] args) {
		/*
		SingletonPatternClass4 ins1 = SingletonPatternClass4.getInstance();
		SingletonPatternClass4 ins2 = SingletonPatternClass4.getInstance();
		System.out.println(ins1 == ins2);
		*/
	}
}