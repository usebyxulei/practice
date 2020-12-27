package com.example.practice.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest implements Runnable {

    final Lock lock = new ReentrantLock();

    private String name;

    public ThreadTest(String name) {
        super();
        this.name = name;
    }

    @Override
    public void run() {
        //for (int i = 1; i < 10; i++) {
            System.out.println("线程" + name + ":" );
       // }
    }

    public static void main(String[] args) {
        CountDownLatch countDownLatchA = new CountDownLatch(1);
        CountDownLatch countDownLatchB = new CountDownLatch(1);

        Thread threadA = new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
            countDownLatchA.countDown();
        }, "Thread-A");

        Thread threadB = new Thread(() -> {
            try {
                countDownLatchA.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
            countDownLatchB.countDown();
        }, "Thread-B");

        Thread threadC = new Thread(() -> {
            try {
                countDownLatchB.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName());
        }, "Thread-C");

        threadA.start();
        threadB.start();
        threadC.start();

        List<String> list = new ArrayList<>(Arrays.asList("a","b","c","f","b","e","d"));
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println("------"+next+"------");
            if ("b".equals(next)) {
                iterator.remove();
            }
        }
        System.out.println(list.toString());
    }

    public static void main2(String[] args) {
        ThreadTest t1 = new ThreadTest("A");
        ThreadTest t2 = new ThreadTest("B");
        ThreadTest t3 = new ThreadTest("C");

        Thread A = new Thread(t1);
        Thread B = new Thread(t2);
        Thread C = new Thread(t3);

        try {
            A.start();
            A.join();
            B.start();
            B.join();
            C.start();
            C.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
