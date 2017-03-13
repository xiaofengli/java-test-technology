package com.webbertech.java.concurrent.threadtimeoutcontrol;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.Callable;

class MyUpdaterAgent implements Runnable {

	public int randomInteger(int min, int max) {
		// Random rand = new Random();
		int randomNum = min + (int) (Math.random() * ((max - min) + 1));
		return randomNum;
	}

	static int id = 0;
	public void run() {
		System.out.print("Thread id: " + id++ + " ");

		System.out.println("do something");

		while (!Thread.currentThread().isInterrupted()) {}
		
		// int randN = randomInteger(4000,8000);
		int randN = randomInteger(6000, 8000);

		System.out.println("The worker thread will sleep for: " + randN + " , thread timeout is 5000");
		// socket communication
		try {
			Thread.sleep(randN);// relative long time
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		
		
		System.out.println("^_^ finish my work successfully:P:P:P");
	}
}

public class TestThreadTimeoutNonBlockingAPI2 {
	private ExecutorService workerThreadPool;
    private ExecutorService watcherThreadPool;
    
	public TestThreadTimeoutNonBlockingAPI2() {
		setThreadPool();
	}

	public void setThreadPool() {
		workerThreadPool = Executors.newFixedThreadPool(1,
				// Use daemon threads so they don't prevent Tomcat shutdown
				new ThreadFactory() {
					public Thread newThread(Runnable r) {
						Thread t = Executors.defaultThreadFactory().newThread(r);
						t.setName("WorkerThread");
						t.setDaemon(true);
						return t;
					}
				});
		
		watcherThreadPool = Executors.newFixedThreadPool(1,
				new ThreadFactory() {
					public Thread newThread(Runnable r) {
						Thread t = Executors.defaultThreadFactory().newThread(r);
						t.setName("WatcherThread");
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

	

	// this is the method from my original class,
	// might be bad method name for now
	private void executeThread() {
		watcherThreadPool.execute(new Runnable() {
			public void run() {
				Future<?> future = workerThreadPool.submit(new MyUpdaterAgent());
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
				if (future.isCancelled()) {
					System.out.println("task has been cancelled");
				}
			}
		});
	}

	public static void main(String[] args) {
		TestThreadTimeoutNonBlockingAPI2 nonBlockingTest = new TestThreadTimeoutNonBlockingAPI2();
		nonBlockingTest.enqueueTask();
	}
}