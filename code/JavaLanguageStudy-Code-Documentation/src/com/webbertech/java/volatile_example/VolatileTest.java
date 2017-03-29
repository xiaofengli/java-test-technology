package com.webbertech.java.volatile_example;

//https://dzone.com/articles/java-volatile-keyword-0
//try to understand the following code,

public class VolatileTest {
	
	/*When test it and remove the volatile, it will have a infinite loop in the ChangeListener.
	  The reason is that when the MY_INT is updated ChangeMaker and it does not push to
	  the main memory so ChangeListener does not get the update.
	*/
	private static volatile int MY_INT = 0;
	
	
	//private static int MY_INT = 0;
	static class ChangeListener extends Thread {
		@Override
		public void run() {
			int local_value = MY_INT;
			while (local_value < 5) {
				//System.out.println(local_value + " " + MY_INT);
				if (local_value != MY_INT) {
					System.out.println("Got Change for MY_INT :"+ MY_INT);
					local_value = MY_INT;
				}
			}
		}
	}

	static class ChangeMaker extends Thread {
		@Override
		public void run() {
			int local_value = MY_INT;
			while (MY_INT < 5) {
				int temp = local_value+1;
				System.out.println("Incrementing MY_INT to " + temp);
				MY_INT = ++local_value;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		new ChangeListener().start();
		new ChangeMaker().start();
	}
}