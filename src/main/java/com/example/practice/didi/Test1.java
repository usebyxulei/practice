package com.example.practice.didi;

public class Test1 {

    public static void main(String[] args) {
        int i = 10;
        int j = 5;
        Test1 test = new Test1();
        System.out.println("i:" + i + " j:" + j);
        test.doSwap(i, j);
        System.out.println("i:" + i + " j:" + j);
    }
    public void doSwap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }
}
