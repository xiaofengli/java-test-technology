package com.webbertech.java.iteratemap;
import java.util.Iterator;
import java.util.Map;

public class IterateMap {

	 public static void main(String[] args) {
		//use map key to iterate is simple
		 for(Map.Entry m: System.getenv().entrySet()) {
			 System.out.println(m.getKey() + ":" + m.getValue());
		 }
		 
		 //use this is ok too
		 System.out.println("===================");
		 Iterator<String> it =System.getenv().keySet().iterator();
		 while (it.hasNext()) {
			 String key = it.next() ;
			 System.out.println(key + ": " + System.getenv().get(key));
		 }
	 }
}
