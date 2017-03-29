package com.webbertech.java.concurrent.timetask;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
 
public class MyTimerTask extends TimerTask {
 
    @Override
    public void run() {
        System.out.println("Timer task started at:"+new Date());
        completeTask();
        System.out.println("Timer task finished at:"+new Date());
    }
    
    private void completeTask() {
        try {
            //assuming it takes half to complete the task
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
     
    public static void main(String args[]){
        TimerTask timerTask = new MyTimerTask();
        //running timer task as daemon thread
        Timer timer = new Timer(true);
        //do some timing to see how the task works
        long time1= System.nanoTime();
        
        //this interval should be longer than the thread execution time 
        //otherwise the thread queue will be increasing
        timer.scheduleAtFixedRate(timerTask, 0, 3*1000);
        System.out.println("TimerTask started");
       
        //cancel after 13 sec
        try {
            Thread.sleep(12000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long time2= System.nanoTime();
        System.out.println((time2-time1)/10^9);
        timer.cancel();
        System.out.println("TimerTask cancelled");
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}