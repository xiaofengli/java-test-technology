package com.webbertech.java.stringtype;

public class StringTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s ="abcdefg";
		char[] c = s.toCharArray();
		for(char c1: c) {
			System.out.println(c1);
		}
		
		s.replace('b','a');
		
		s.replaceAll("a", "b");
		System.out.print(s);
	}

}
