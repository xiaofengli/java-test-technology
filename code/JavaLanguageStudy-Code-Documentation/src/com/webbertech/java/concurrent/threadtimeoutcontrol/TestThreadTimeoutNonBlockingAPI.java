package com.webbertech.java.concurrent.threadtimeoutcontrol;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.Callable;

class UpdaterAgent implements Runnable {

	public int randomInteger(int min, int max) {
		// Random rand = new Random();
		int randomNum = min + (int) (Math.random() * ((max - min) + 1));
		return randomNum;
	}

	public void run() {
		System.out.print("Thread id: " + Thread.currentThread().getName() + " ");

		System.out.println("do something");

		// int randN = randomInteger(4000,8000);
		int randN = randomInteger(6000, 8000);

		System.out.println("The worker thread will sleep for: " + randN + " , thread timeout is 5000");
		// socket communication
		try {
			Thread.sleep(randN);// relative long time
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("^_^ finish my work successfully:P:P:P");
	}
}

public class TestThreadTimeoutNonBlockingAPI {
	private ExecutorService threadPool;

	public TestThreadTimeoutNonBlockingAPI() {
		setThreadPool();
	}

	public void setThreadPool() {
		threadPool = Executors.newFixedThreadPool(1,
				// Use daemon threads so they don't prevent Tomcat shutdown
				new ThreadFactory() {
					public Thread newThread(Runnable r) {
						Thread t = Executors.defaultThreadFactory().newThread(r);
						t.setName("WorkerThread");
						t.setDaemon(true);
						return t;
					}
				});

	}

	// simulate a sequence of update requests in fixed time interval
	// just for demo
	public void enqueueTask() {

		while (true) {
			executeThread();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	static int id = 0;

	// this is the method from my original class,
	// might be bad method name for now
	private void executeThread() {
		threadPool.execute(new Runnable() {
			public void run() {

				// Callable and FutureTask is to save the effort to
				// create another ExecutorService object to create Future object
				// by calling its submit() method
				// also future.cancel internally is thread interrupt()..
				Callable<UpdaterAgent> callable = (Callable) Executors.callable(new UpdaterAgent(), null);
				FutureTask<?> future = new FutureTask<UpdaterAgent>(callable);
				Thread socketUpdaterAgentThread = new Thread(future);
				socketUpdaterAgentThread.setName(String.valueOf(id++));
				socketUpdaterAgentThread.start();

				try {
					future.get(5000, TimeUnit.MILLISECONDS);
				} catch (InterruptedException e) {
					future.cancel(true);
					e.printStackTrace();
				} catch (ExecutionException e) {
					e.printStackTrace();
				} catch (TimeoutException e) {
					future.cancel(true);
					e.printStackTrace();
				}
			}
		});
	}

	public static void main(String[] args) {
		TestThreadTimeoutNonBlockingAPI nonBlockingTest = new TestThreadTimeoutNonBlockingAPI();
		nonBlockingTest.enqueueTask();
	}
}