package com.webbertech.java.concurrent.synchronization;

public class ThreadInterruptTest3 extends Thread {

	public void run() {
		for (int i = 1; i <= 5; i++)
			System.out.println(i);
	}

	public static void main(String args[]) {
		ThreadInterruptTest3 t1 = new ThreadInterruptTest3();
		t1.start();

		t1.interrupt();

	}
}