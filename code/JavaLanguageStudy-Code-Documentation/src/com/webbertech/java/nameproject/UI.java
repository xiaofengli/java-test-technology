package com.webbertech.java.nameproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


/*This class is used for user interface only
*/
public class UI extends JPanel
implements ActionListener {
   
	private static final long serialVersionUID = 1L;
	JTextArea console;
	 JFileChooser fc;
	 JButton openButton, saveButton, clearButton, sortingButton;
	 JComboBox<String> comboBox = null;
	 static private final String newline = "\n";
	 
	public UI() {
		super(new BorderLayout());
		 
        //Create the log first, because the action listeners
        //need to refer to it.
        console = new JTextArea(20,40);
        console.setMargin(new Insets(5,5,5,5));
        console.setEditable(false);
        this.setFont("Bitstream Cyberbit", 18);
        JScrollPane logScrollPane = new JScrollPane(console);
 
        //Create a file chooser
        fc = new JFileChooser();
        
        openButton = new JButton("Open a File...",
                createImageIcon("/images/Open16.gif"));
        openButton.addActionListener(this);

        clearButton = new JButton("Clear");
        clearButton.addActionListener(this);
     
        sortingButton = new JButton("Start Sorting");
        sortingButton.addActionListener(this);
     
        //For layout purposes, put the buttons in a separate panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT)); //use FlowLayout
        buttonPanel.add(openButton);
        buttonPanel.add(clearButton);

        //Add sorting functionality
        String[] choices = new String[] {"Ascending", "Descending"};
        comboBox = new JComboBox<String>(choices);
        buttonPanel.add(comboBox);
        buttonPanel.add(sortingButton);

        //Add the buttons and the log to this panel.
        add(buttonPanel,BorderLayout.PAGE_START);
        add(logScrollPane, BorderLayout.CENTER);
	}
	
	//set of names used for UI display
	 private SortedSet<NameToken> allNames = null; 
	 
	@Override
	public void actionPerformed(ActionEvent e) {
		 //Handle open button action.
        if (e.getSource() == openButton) {
            int returnVal = fc.showOpenDialog(UI.this);
 
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
        
                //This is where a real application would open the file.
                console.append("Opening: " + file.getName() + "." + newline);
                NameFileParser parser = new NameFileParser();
        	    allNames = parser.parse(file.toString());
        	  
        	    //default using ascending order to show the result
        	    showAscendingOrder(allNames);
        	    
            } else {
                console.append("Open command cancelled by user." + newline);
            }
            console.setCaretPosition(console.getDocument().getLength());
      
            //Handle save button action.
        } else if (e.getSource() == clearButton) {
        	clearText();
        } else if (e.getSource() == sortingButton ) {
         
        	console.append("Now sorting by: " + (String)comboBox.getSelectedItem() + "\n");
        	if (((String)comboBox.getSelectedItem()).equals("Ascending")) {
        	     try {
        	    	 clearText();
        	    	showAscendingOrder(allNames); 
        		 } catch (Exception ex) {
        			 ex.printStackTrace();
        		 }
        	    
        	 } else if (((String)comboBox.getSelectedItem()).equals("Descending")) {
        		  try {
        				clearText(); 	
          	    	showDescendingOrder(allNames); 
          	    } catch (Exception ex) {
          			 ex.printStackTrace();
          		 }
        	}
        	
        	
        }
 	}
   
     private void showAscendingOrder(SortedSet<NameToken> allNames) {
    	
    	 if( allNames == null) { 
    		 return;
    	 } else {
    	  
    	//check the set
 	    Iterator<NameToken> it = allNames.iterator();
 	    int num =0;
 	    while (it.hasNext()) {
 	       NameToken token = it.next();
 	       console.append((num++ + ": " + token.getName()+" " +token.getScore()));
 	       console.append(newline);
 	    }
       }
     }
     
     private void showDescendingOrder(SortedSet<NameToken> allNames) {
     	
    	 if( allNames == null) { 
    		 return;
    	 } else {
    	  
    		TreeSet<NameToken> reversedSet = null;  
    		reversedSet = (TreeSet<NameToken>) ((TreeSet<NameToken>)allNames).descendingSet();
    				 
    	//check the set
 	    Iterator<NameToken> it = reversedSet.iterator();
 	    int num =0;
 	    clearText();
 	    while (it.hasNext()) {
 	       NameToken token = it.next();
 	       console.append((num++ + ": " + token.getName()+" " +token.getScore()));
 	       console.append(newline);
 	    }
       }
     }
	
	private void clearText() {
		try {
		  console.setText(null);
          console.setCaretPosition(console.getDocument().getLength());
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void setFont(String fontStyle, int size) {
		Font font = new Font(fontStyle, Font.BOLD, size);
		
			try {
				console.setFont(font);
				console.setForeground(Color.BLACK);
						
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	protected static ImageIcon createImageIcon(String path) {
	        java.net.URL imgURL = UI.class.getResource(path);
	        if (imgURL != null) {
	            return new ImageIcon(imgURL);
	        } else {
	            System.err.println("Couldn't find file: " + path);
	            return null;
	        }
	}
	 
	
	//add JPanel to JFrame and show frame
	public static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Choose good names");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //get screensize
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        //place jframe object in the center of the screen, which is x,y is the top left corner of the jframe
        frame.setLocation(frame.getSize().width/2, frame.getSize().height/2);
        frame.setSize(40, 80);
       
        //Add content to the window.
        frame.add(new UI());
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

}
