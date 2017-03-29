package com.webbertech.java.iteratemap;
//this is the code to show how to use PriorityQueue

import java.util.PriorityQueue;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Statistics {
	
  public static void main(String[] args) {
	  Random rand =new Random(47);
	  
	  List<Integer> s = new ArrayList<>();
	  PriorityQueue<Integer> pq4 = new PriorityQueue<>(); 
	  
	  for(int i=0;i<10;i++) {
		   int r = rand.nextInt(32);
		   s.add(r);
		   pq4.offer(r);
	  }
	  
	  System.out.println("Printing List");
	  System.out.println(s);
	  
	  //does not sort it
	  System.out.println("Printing PQ with its default constructor");
	  PriorityQueue<Integer> pq0 = new PriorityQueue<>(s); 
	  System.out.println(pq0);
	  
	  //does not sort it
	  PriorityQueue<Integer> pq1 = new PriorityQueue<>(); 
	  pq1.addAll(s);
	  System.out.println("Printing priority queue");
	  System.out.println(pq1);
	  
	  //sort it to some extent but not right?
	  System.out.println("Using reversed priority queue");
	  PriorityQueue<Integer> pq2 = new PriorityQueue<>(s.size(),Collections.reverseOrder()); 
      pq2.addAll(s);
      System.out.println(pq2);
      
      //remove, peek, pull will trigger 
      //the priority to be adjusted
      System.out.println("Using offer to set priority");
      System.out.println(pq4);
      
      //using peek to read the priority of the list
      System.out.println("Using peek to see priority");
      Iterator it = pq4.iterator();
      while(it.hasNext()) {
    	  System.out.print(it.next()+" ");
      }
      
  }
}
