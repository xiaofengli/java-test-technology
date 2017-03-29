package com.webbertech.java.designpattern;

//one traditional way of creating singleton design pattern is to use double checked locking
// pay attention to the usage of volatile

public class SingletonPatternClass {

 private static volatile SingletonPatternClass INSTANCE;
 private SingletonPatternClass() {
	 System.out.println("do something in constructor");
 }
 
 public static SingletonPatternClass getInstance() {
	 //check once
	 if (INSTANCE == null) {
		 synchronized(SingletonPatternClass.class) {
			 //double checking singleton instance
			 if (INSTANCE == null) {
				 INSTANCE = new SingletonPatternClass();
			 }
		 }
	 }
	 return INSTANCE;
 }
 
 public static void main(String[] args) {
	 SingletonPatternClass ins1 = getInstance();
	 SingletonPatternClass ins2 = getInstance();
	 SingletonPatternClass ins3 = getInstance();
	 System.out.println(ins1 == ins3);
 }
}
