package com.webbertech.java.wordfrequencycount;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

public class FrequencyCounting {

	public Map<Integer, Integer> countInteger(int[] arry) {
		
         int frequency[] = new int[arry.length];
		
	     Map<Integer, Integer>  pollMap= new HashMap<Integer, Integer>();
	    
	    //use poll[i] as position to record the occurance, since the position will duplicate
	    //so we will need to remove duplicate keys
		for(int i=0; i< arry.length; i++) {
		     
		     pollMap.put(arry[i], ++frequency[arry[i]] );
		 }
		return pollMap; 
	}

	 public void displayPoll(Map<? extends Object, Integer> pollMap) {
			
			//remove duplicate key
		    Set<?> keys= pollMap.keySet(); 
		    
		    Iterator<?> iter = keys.iterator();
			
		    while(iter.hasNext())
		    {
		      	Integer key = (Integer)iter.next();
		     	Integer value = pollMap.get(key);
		    	System.out.println(key + " " + value);
		    }
	 }
	
	 public void displayWordCounts(Map<? extends Object, Integer> pollMap) {
			
			//remove duplicate key
		    Set<?> keys= pollMap.keySet(); 
		    
		    Iterator<?> iter = keys.iterator();
			
		    while(iter.hasNext())
		    {
		      	String key = (String)iter.next();
		     	Integer value = pollMap.get(key);
		    	System.out.println(key + " " + value);
		    }
	 }
	 
	 
    public Map<String, Integer> countWord(String[] line) {
        if (line == null) return null;
    	Map<String, Integer> m = new HashMap<String, Integer>();
    	 for(int i=0;i< line.length;i++) {
    		if (m.containsKey(line[i])) {
    		 int count= m.get(line[i]);
    		 count++;
    		 m.put(line[i], count); 
    		}  else {
    			m.put(line[i], 1);
    		}
    	 }
    	return m;
    }	
    
    //top 10 words in a file
    
    //This is buggy now, need to get another map to collect the poll from wordsMap
    public void readFile(File filePath) {
    
    	try {
    	 BufferedReader b = new BufferedReader(new FileReader(filePath));
    	 String line;
		 Map<String, Integer> wordsMap = new HashMap<String, Integer>();
		 Map<String, Integer> sortedMap = new HashMap<String, Integer>();
    	  while((line=b.readLine())!=null) {
    		  wordsMap = countWord(line.split("\\s+"));
    		  sortedMap.putAll(wordsMap);
    		  //System.out.println(line);
    	  }
    	  
    	  displayWordCounts(sortedMap);
    	  b.close();
    	     
         } catch (Exception e) {
        	e.printStackTrace();
         }
    	
    	
   }
    
	public static void main(String args[] ) {
		FrequencyCounting f = new FrequencyCounting();
		/*
		int[] poll = {1, 2, 3,4,5,6,4, 4,5,3,3,2,2,1,1,3,3,4,3,2,3,3,2,2};

	    Map<Integer, Integer> m = f.countInteger(poll);
		f.displayPoll(m);
	   
		
	    String[] words= {"a", "b", "c", "d", "a", "b", "d", "e"};
	    Map<String, Integer> m1 = f.countWord(words);
	    f.displayWordCounts(m1);
	    
	    */
		f.readFile(new File("E:/PractiseCode/FrequencyCounting/src/test.txt"));
	}
	
}



class myComparator implements Comparator {

	@Override
	public int compare(Object arg0, Object arg1) {
		// TODO Auto-generated method stub
		
		return 0;
	}
	
}