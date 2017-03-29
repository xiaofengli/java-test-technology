package com.webbertech.java.concurrent.threadlock2;
import static com.webbertech.java.concurrent.threadlock2.MyUtil.doMySlowCalculation;

public class SynchronizedCalculator {
    private int calculatedValue;
    private int value;

    public synchronized void calculate(int value) { 
        this.value = value;
        this.calculatedValue = doMySlowCalculation(value);
    }

    public synchronized int getCalculatedValue() {
        return calculatedValue;
    }

    public synchronized int getValue() {
        return value;
    }
}