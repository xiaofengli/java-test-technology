package com.webbertech.java.nameproject;

import java.util.Comparator;


class NameTokenComparator implements Comparator {
	//implementation for comparator interfafce, then you will need a comparator class 
	// say NameTokenComparator and init it
	//in the constructor of TreeSet(new NameTokenComparator)
	
	@Override
	public int compare(Object token1, Object token2) {
		if (Integer.parseInt(((NameToken)token1).getScore()) >= Integer.parseInt(((NameToken)token2).getScore()) ) {
		    return 1;
		} else {
		  return -1;
		}
	}
}


/*This is the token object class*/

public class NameToken {
  private String name;
  private String score;
  
  public String getName() {
	  return this.name;
  }
  
  public String getScore() {
	  return this.score;
  }
 
  public NameToken(String name, String score) {
	 this.name=name;
	 this.score=score;
  }
  
  
  //use the following for HashSet to remove duplication
  //TODO need to implement CompareTo since the TreeSet and TreeMap will 
  //still have duplicate
  @Override
  public int hashCode() {
	return Integer.valueOf(name.hashCode());
  }
  
  @Override
  public boolean equals(Object o){
       if ( this.hashCode() == ((NameToken)o).hashCode() ) {
    	   return true;
       } else 
    	   return false;
  }
  
}
