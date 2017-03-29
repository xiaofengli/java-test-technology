package com.webbertech.java.designpattern;

/*This is an easiest way to make a class singleton.
 When you implement the singleton design pattern for a class
 you always want to make sure that it is thread-safe.
 Enum is thread-safe by default.
 This way is simple but it might not be obvious that what 'enum' does here for this class.
 */
public enum SingletonPatternClass3 {
	INSTANCE;
	
	public static void main(String[] args) {
		SingletonPatternClass3 ins1 = SingletonPatternClass3.INSTANCE;
		SingletonPatternClass3 ins2 = SingletonPatternClass3.INSTANCE;
		System.out.println(ins1==ins2);
	}
}
