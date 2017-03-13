package com.webbertech.java.concurrent.synchronization;

//this is non static synchronization

public class SynchronizationTest1{  
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
	SynchronizationTest1 s = new SynchronizationTest1();
	
	Table obj = s.new Table();//only one object  
	MyThread1 t1=s.new MyThread1(obj);  
	MyThread2 t2=s.new MyThread2(obj);  
	t1.start();  
	t2.start();  
	}  
}  