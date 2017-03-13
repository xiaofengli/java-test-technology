package com.webbertech.java.concurrent.threadjoin;

public class ThreadJoinExample {
	 
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyRunnable(), "t1");
        Thread t2 = new Thread(new MyRunnable(), "t2");
        Thread t3 = new Thread(new MyRunnable(), "t3");
         
        t1.start();
         
        //start second thread after waiting for 2 seconds or if it's dead
        try {
            t1.join(2000); 
            System.out.println(System.currentTimeMillis()/1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println(System.currentTimeMillis()/1000);
        t2.start();  
         
        //start third thread only when first thread is dead
        try {
        	
        	/* code is executed sequentially, here means
        	 * please wait until t1 is finished.
        	 * join() vs wait() is that wait() does not have a dependency check.
        	 * join(time) that time is checking agains the thread 
        	 * state and wait() is simpler 
        	*/
            t1.join(); 
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
         
        t3.start();
         
        /*The following is used for the main thread to 
         * wait until all the thread are finished and then
         * finish main thread.
         * */
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
         
        System.out.println("All threads are dead, exiting main thread");
    }
 
}
 
class MyRunnable implements Runnable{
 
    @Override
    public void run() {
        System.out.println("Thread started:::"+Thread.currentThread().getName());
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread ended:::"+Thread.currentThread().getName());
    }
     
}