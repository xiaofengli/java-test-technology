package com.webbertech.java.enumclass;

public class Enum1 {

	  EAST("this is east"),
	  WEST("this is west"),
	  NORTH("this is north"),
	  SOUTH("this is south"),
	  
	  private String description;
	  
	  public  Enum1(String description) {
		  this.description= description;
	  }
	  
	  public String getDescription() {
		  return this.description;
	  }
	  
	  public static void main(String[] args) {
		  for(String direction: Enum1.values() ){
			  
		  }
	  }
	  
}
