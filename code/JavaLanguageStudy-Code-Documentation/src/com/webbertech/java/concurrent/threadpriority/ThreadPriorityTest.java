package com.webbertech.java.concurrent.threadpriority;

public class ThreadPriorityTest implements Runnable {

	private String name;
	public ThreadPriorityTest(String name) {
		this.name= name;
	}
	
	public void run() {
	    try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(this.name+" id is: "+Thread.currentThread().getId());
		System.out.println(this.name+" priority is: "+ Thread.currentThread().getPriority());
	}
	
	public static void main(String[] args) {
		Thread t1 = new Thread(new ThreadPriorityTest("t1"));
		t1.setPriority(Thread.MIN_PRIORITY);
		Thread t2 = new Thread(new ThreadPriorityTest("t2"));
		t2.setPriority(10);
		Thread t3 = new Thread(new ThreadPriorityTest("t3"));
		t3.setDaemon(true);
		t3.setPriority(4);
		t1.start();
		t2.start();
		t3.start();
	}
}
