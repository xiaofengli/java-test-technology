package com.webbertech.java.iterator;
import java.util.Iterator;

public class MyIterator implements Iterable<String> {

	  String[] words = "and that is how this is done".split("\\s+");
		
	  
	@Override
	public Iterator<String> iterator() {
		
		return new Iterator<String>() {
			private int index =0;
			public boolean hasNext() {
			   return index< words.length;
			}
			
			public String next() {
				return words[index++];
			}
			
			public void remove() {
				throw new UnsupportedOperationException();
			}
		
		};
	}
	
	public static void main(String[] args) {
		//each object return each word??
		
		for(String s: new MyIterator()){
			System.out.print(s+ " ");
		}
	
	}

}
