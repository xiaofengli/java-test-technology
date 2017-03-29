package com.webbertech.java.concurrent.synchronization;
/*
 * t1.interrupt(); will not do anything because
 * no sleep or wait state is found, so it will set interrupted
 * flag to true.
 * */

public class ThreadInterruptTest4 extends Thread{
	public void run() {
		for (int i = 1; i <= 5; i++)
			System.out.println(i);
	}

	public static void main(String args[]) {
		ThreadInterruptTest4 t1 = new ThreadInterruptTest4();
		t1.start();

		t1.interrupt();

	}
}
