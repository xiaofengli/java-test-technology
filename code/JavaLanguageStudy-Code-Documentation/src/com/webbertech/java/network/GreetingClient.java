package com.webbertech.java.network;
// File Name GreetingClient.java

import java.net.*;
import java.io.*;

public class GreetingClient
{
   public static void main(String [] args)
   {
      final String serverName = "192.168.1.105";
      final int port = 8300;
       Console c = System.console();
       String chat; 
       try {
    	   System.out.println("Connecting to " + serverName + " on port " + port);
    	   Socket client = new Socket(serverName, port);
    	   System.out.println("Just connected to " + client.getRemoteSocketAddress());
    	   OutputStream outToServer = client.getOutputStream();
    	   DataOutputStream out = new DataOutputStream(outToServer);
    	   out.writeUTF("Hello from " + client.getLocalSocketAddress());
    	   InputStream inFromServer = client.getInputStream();
    	   DataInputStream in = new DataInputStream(inFromServer);
    	   System.out.println("Server says " + in.readUTF());
    	  
    	   
    	   //if connection is not terminated
    	   while (true) {
    		   chat = c.readLine("Enter your chat: ");
    		 //type this to end chat
    		 if (chat.equals("byexxx")) {
    			 client.close();
    			 break;
    		 }
    		 else {
    			 
    			 //write to server
    			 out.flush();
    			 out.writeUTF(chat);
    			 
    			 //get from server
    			    inFromServer = client.getInputStream();
    	    	   in = new DataInputStream(inFromServer);
    	    	   System.out.println("Server says " + in.readUTF());
    		 }
    	   }
       } catch(IOException e) {
         e.printStackTrace();
       }
     
   }
}