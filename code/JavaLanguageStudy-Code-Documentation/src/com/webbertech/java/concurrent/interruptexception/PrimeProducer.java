package com.webbertech.java.concurrent.interruptexception;
import java.math.BigInteger;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

//Interrupts can be swallowed if you know the thread is about to exit
public class PrimeProducer extends Thread {
    private final BlockingQueue<BigInteger> queue;
    PrimeProducer(BlockingQueue<BigInteger> queue) {
        this.queue = queue;
    }
 
    public void run() {
        try {
            BigInteger p = BigInteger.ONE;
            int count=0;
            while (!Thread.currentThread().isInterrupted()) {
                queue.put(p = p.nextProbablePrime());
                System.out.println("I did something" + count++);
            }
        } catch (InterruptedException consumed) {
            /* Allow thread to exit */
        	System.out.println("bad boy");
        }
    }
 
    public void cancel() { 
    	interrupt(); 
    }
    
    public static void main(String[] args) {
    	BlockingQueue<BigInteger> queue = new ArrayBlockingQueue<BigInteger>(10); 
    	Thread t = new Thread(new PrimeProducer(queue));
    	t.start();
    	try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	t.interrupt();
    }
}