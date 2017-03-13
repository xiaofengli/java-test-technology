package com.webbertech.java.iteratemap;
//how to use map to do a frequency count
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class FreqMap {
	
  public static void main(String[] args) {
	
	  Random rand =new Random(47);
	  Map<Integer, Integer> m = new HashMap<Integer, Integer>();
	  
	  for(int i=0;i<10;i++) {
		   int r = rand.nextInt(32);
		   System.out.println(r);
		   Integer freq = m.get(r);
		   m.put(r, freq == null ? 1:freq+1); //basically overwrite the value
	  }
	  System.out.println(m);
  }
}