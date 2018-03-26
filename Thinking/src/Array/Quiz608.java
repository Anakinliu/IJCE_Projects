package Array;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Author: Anakinliu
 * Date: 2018/03/19
 * Time: 11:03
 * You may be disappointed if you fail,
 * but you are doomed if you don't try.
 */
/*
给定一个已经按升序排列的数组，找到两个数使他们加起来的和等于特定数。
函数应该返回这两个数的下标，index1必须小于index2。注意返回的值不是 0-based。
 */
public class Quiz608 {
    public static int[] twoSum(int[] nums, int target) {
        // write your code here
        int i,j;
        int l = nums.length;
        int[] result = new int[]{0, 0};
        for (i = 0; i < l; i++) {
            for (j = i+1; j < l; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,15};
        System.out.println(Arrays.toString(twoSum(nums, 9)));
    }
}
