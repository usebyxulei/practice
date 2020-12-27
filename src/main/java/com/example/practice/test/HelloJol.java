package com.example.practice.test;

import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.TimeUnit;

public class HelloJol {
    public static void main(String[] args) throws InterruptedException {

        TimeUnit.SECONDS.sleep(5);

        Object o = new Object();
        String s = ClassLayout.parseInstance(o).toPrintable();
        System.out.println(s);

        System.out.println("==========================");

        /*synchronized (o){
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }*/
        StringBuffer sb = new StringBuffer();//线程安全的
        StringBuilder stringBuilder = new StringBuilder();
    }
}
