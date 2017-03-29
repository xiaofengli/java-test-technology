package com.webbertech.java.concurrent.synchronization;

/*this is non static synchronization
In this example, synchornized does not work, because the two thread does not
share any resource, each passed in a different 
*/

public class SynchronizationTest1dot5{  
	//example of java synchronized method  
class Table{  
	synchronized void printTable(int n){//synchronized method  
	 for(int i=1;i<=5;i++){  
	   System.out.println(n*i);  
	   try{  
	    Thread.sleep(400);  
	   }catch(Exception e){System.out.println(e);}  
	 }  
	}  
}  

class MyThread1 extends Thread{  
	Table t;  
	MyThread1(Table t){  
	this.t=t;  
	}  
	
	public void run(){  
	t.printTable(5);  
	}  

}  

class MyThread2 extends Thread{  
	Table t;  
	MyThread2(Table t){  
	this.t=t;  
	}  
	public void run(){  
	t.printTable(100);  
	}  
} 	
	
	
public static void main(String args[]){  
	SynchronizationTest1dot5 s = new SynchronizationTest1dot5();
	
	Table obj1 = s.new Table();//only one object
	Table obj2 = s.new Table();//only one object  
	MyThread1 t1=s.new MyThread1(obj1);  
	MyThread2 t2=s.new MyThread2(obj2);  
	t1.start();  
	t2.start();  
	}  
}  