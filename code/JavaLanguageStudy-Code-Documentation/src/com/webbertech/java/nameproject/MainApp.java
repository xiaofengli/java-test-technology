package com.webbertech.java.nameproject;

import java.util.Iterator;
import java.util.Set;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class MainApp {

	 //TODO should move this to somewhere else
	 void testFunc() {
		
	    NameFileParser parser = new NameFileParser();
	    Set<NameToken> allNames = parser.parse("..\\names\\name.txt");
	    
	    //check the set
	   
	    Iterator<NameToken> it = allNames.iterator();
	    int num =0;
	    while (it.hasNext()) {
	       NameToken token = it.next();
	       System.out.println(num++ + ": " + token.getName()+" " +token.getScore());
	    }
	    
     }

	 //main entry to start the app
	 public static void main(String args[]) {
   	
		 SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	                //Turn off metal's use of bold fonts
	                UIManager.put("swing.boldMetal", Boolean.FALSE); 
	                UI.createAndShowGUI();
	            }
	        });
		 
         }
	}
