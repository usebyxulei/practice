package com.example.practice.test;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class T03_AtomicInteger {

    private static AtomicInteger m = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[100];
        CountDownLatch latch = new CountDownLatch(threads.length);

        Object o = new Object();

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(()->{
                for (int j = 0; j < 100; j++) {
                    //m.incrementAndGet(); // m++
                    System.out.println(m.incrementAndGet());
                }
                latch.countDown();
            });
           // System.out.println( threads[i] + ":" + m.get());
        }

        Arrays.stream(threads).forEach(t -> t.start());

        latch.await();
    }
}
