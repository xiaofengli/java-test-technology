package com.webbertech.java.nameproject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

/*this file is used to parse the name file
 *each token object is a name with a score
 **/
public class NameFileParser {

	public NameFileParser() {
		// TODO Auto-generated constructor stub
	}
	
	//using sorted set implementation
	/*This function is used to parse a file for each line
	  and break it down to each string token
	 */
	public SortedSet<NameToken> parse(String filePath) {
		
		//use a customized comparator interface class implementation to sort based on the specific
		//field of some object, can't implement Comparable, it does not work
		SortedSet<NameToken> tokens = new TreeSet<NameToken>(new NameTokenComparator());
		String line = null;
		
		try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(filePath);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            
            while((line = bufferedReader.readLine()) != null) {
                //handling whitespace and some unicode whitespace
            	String[] rawTokens = line.trim().split("[\\s\u3000]+");
            	
            	for(String token : rawTokens) {
            	   //the following is for debugging process
                	
            		/*
                	 for(int i=0;i<token.length();i++) {
                		 char c = token.charAt(i);
            		   System.out.printf("%c, %x\n", c, (int)c);	
            		 }
                	 */
            		
            		//process each rawToken
            		NameToken nameToken = processRawToken(token);
            		tokens.add(nameToken);
            	}
            }   
            // Always close files.
            bufferedReader.close();         
        } catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                filePath + "'");                
        } catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + filePath + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
    
		return tokens;
	}
	
	
	/*
	 * input: String token
	 * output: NameToken
	 * 
	 * Function: this is a simple parsing function take a string token to generate a
	 * NameToken object token
	 * */
	private NameToken processRawToken(String token) {
		String nameStr = null;
		String scoreStr = null;
		int delimiter = 0;
		 
		for(int i=0; i< token.length(); i++) {
			
			String hex = String.format("%04x", (int) token.charAt(i));
			
			if (!  hex.equals("0028") ) {
				delimiter++;
				continue;
			} 
			
			break;
		}
		
		nameStr = token.substring(0, delimiter);
		scoreStr = token.substring(delimiter+1, token.length()-2);
		return new NameToken(nameStr, scoreStr);
	}
	
	
}
