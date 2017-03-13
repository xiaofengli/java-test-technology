package com.webbertech.java.concurrent.synchronization;

/*
 * If you remove t1.interrupt(); it will 
 * wait for a long time until sleep is done
 * and continue the rest of the thread work
 * 
 * */
public class ThreadInterruptTest2 extends Thread {
	public void run() {
		try {
			Thread.sleep(10000);
			System.out.println("task");
		} catch (InterruptedException e) {
			System.out.println("Exception handled " + e);
		}
		System.out.println("thread is running...");
	}

	public static void main(String args[]) {
		ThreadInterruptTest2 t1 = new ThreadInterruptTest2();
		t1.start();

		t1.interrupt();

	}
}