package com.webbertech.java.network;
import java.net.InetAddress;
import java.net.UnknownHostException;
public class InetExample {
	 InetAddress addr;
	InetExample(String hostname) throws UnknownHostException {
	   addr = InetAddress.getByName(hostname);
	}
	
	public void display()  throws UnknownHostException {
		System.out.println(addr.toString());
		System.out.println(addr.getCanonicalHostName());
		System.out.println(addr.getLocalHost());
		System.out.println(addr.getHostAddress());
		System.out.println(addr.getHostName());
	}
	
	public static void main(String[] args) {
		InetExample obj;
		try {
			obj = new InetExample("localhost");
			obj.display();
			
		} catch (UnknownHostException e) {
			
		}
	}
}
