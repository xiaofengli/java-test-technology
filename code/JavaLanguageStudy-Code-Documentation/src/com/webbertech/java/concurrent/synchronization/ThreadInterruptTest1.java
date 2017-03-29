package com.webbertech.java.concurrent.synchronization;

public class ThreadInterruptTest1 extends Thread {
	public void run() {
		try {
			Thread.sleep(1000);
			System.out.println("task");
		} catch (InterruptedException e) {
			//throw new RuntimeException("Thread interrupted..." + e);
		   e.printStackTrace();
		}
		
		System.out.println("after breaking out "
				+ "from sleep it will continue print this line");

	}

	public static void main(String args[]) {
		ThreadInterruptTest1 t1 = new ThreadInterruptTest1();
		t1.start();
		try {
			t1.interrupt();
		} catch (Exception e) {
			System.out.println("Exception handled " + e);
		}
	}
}