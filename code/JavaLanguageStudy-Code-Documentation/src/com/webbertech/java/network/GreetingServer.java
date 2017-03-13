package com.webbertech.java.network;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;


public class GreetingServer extends Thread {

	private ServerSocket serverSocket;
	
	public GreetingServer(int port) throws IOException {
			//server uses special port and dedicated IP
		    serverSocket = new ServerSocket(port,1,InetAddress.getByName("192.168.1.105"));
			//infinite connecting time
			serverSocket.setSoTimeout(0);
	}
	
	private Socket server;
	
	public void run()
	   {
	      while(true)
	      {
	         try
	         {
	            System.out.println("Waiting for client on port " +
	            serverSocket.getLocalPort() + "...");
	            Socket server = serverSocket.accept();
	            System.out.println("Just connected to "
	                  + server.getRemoteSocketAddress());
	            DataInputStream in =
	                  new DataInputStream(server.getInputStream());
	            System.out.println(in.readUTF());
	            DataOutputStream out =
	                 new DataOutputStream(server.getOutputStream());
	            out.writeUTF("Thank you for connecting to "
	              + server.getLocalSocketAddress() + "\nGoodbye!");
	            server.close();
	         }catch(SocketTimeoutException s)
	         {
	            System.out.println("Socket timed out!");
	            break;
	         }catch(IOException e)
	         {
	            e.printStackTrace();
	            break;
	         }
	      }
	   }
	   public static void main(String [] args)
	   {
	      
	      try
	      {
	         Thread t = new GreetingServer(8300);
	         t.start();
	      }catch(IOException e)
	      {
	         e.printStackTrace();
	      }
	   }
}
