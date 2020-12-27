package com.example.practice.test;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Test5 {
    public static Set<Integer> getTop10(int[] array) {
        TreeSet<Integer> top10 = new TreeSet();
        for (int i = 0; i < array.length; i++) {
            if (top10.size() < 10) {
                top10.add(array[i]);
            } else if (top10.first() < array[i]) {
                Object obj = top10.first();
                top10.remove(obj);
                top10.add(array[i]);
            }
        }
        System.out.println(top10);
        return top10;
    }

    public static void main(String[] args) {
        int numberCount = 1000_0000;
        int maxNumber = numberCount;
        int inputArray[] = new int[numberCount];
        Random random = new Random();
        for (int i = 0; i < numberCount; ++i) {
            inputArray[i] = Math.abs(random.nextInt(maxNumber));

        }
        System.out.println("Sort begin...");
        long current = System.currentTimeMillis();
        Set<Integer> result = getTop10(inputArray);
        //System.out.println(result);
        System.out.println("Spend time:"
                + (System.currentTimeMillis() - current));

    }
}
