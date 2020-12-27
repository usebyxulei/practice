package com.example.practice.didi;

/**
 * 滴滴一面
 * 算法题
 * 找出数组中第二大的数
 */
public class SecondMaxNum {
    public static void main(String[] args) {
        int[] arrays = new int[]{11,19,6,19,6,5,11};
        System.out.println(getSecondMaxNum(arrays));
    }

    public static int getSecondMaxNum(int [] arrays){
        int max,secondMax;
        secondMax = max = arrays[0];
        for (int i = 1; i < arrays.length; i++) {
            if(arrays[i] > max){
                secondMax = max;
                max = arrays[i];
            }else {
                if(arrays[i] > secondMax && arrays[i] != max) secondMax = arrays[i];
            }
        }
        return secondMax;
    }
}
