package com.example.practice.test;

/**
 * lazy loading
 * 懒汉式
 *
 */
public class Mgr06 {
    private static volatile Mgr06 INSTANCE; //volatile 禁止指令重排序

    private Mgr06(){}

    public static Mgr06 getInstance(){
        if (INSTANCE == null){
            //DCL Double Check Lock
            synchronized (Mgr06.class){
                //双重检查
               if(INSTANCE == null){
                   try {
                       Thread.sleep(1);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
                   INSTANCE = new Mgr06();
               }
            }
        }
        return INSTANCE;
    }

    public void m(){
        System.out.println("m");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Mgr06.getInstance().hashCode());
            }).start();
        }
    }
}
