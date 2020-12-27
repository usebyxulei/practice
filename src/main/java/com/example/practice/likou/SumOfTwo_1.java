package com.example.practice.likou;

/**
 * 两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class SumOfTwo_1 {

    public static int[] twoSum(int[] nums, int target) {
        int head = 0, tail = nums.length - 1;
        while (tail > head) {
            int sum = nums[head] + nums[tail];
            if (sum == target) {
                System.out.println("成功");
                System.out.println(head + "," + tail);
                break;
            } else if (sum < target) {
                System.out.println("小于");
                System.out.println(head + "," + tail);
                head++;
            } else if (sum > target) {
                System.out.println("大于");
                System.out.println(head + "," + tail);
                tail--;
            }
        }
        return new int[]{head, tail};
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 2, 7, 11, 15, 7, 2};
        int target = 9;
        int[] twoSum = twoSum(nums, target);
        System.out.println(twoSum[0] + "," + twoSum[1]);
    }
}
