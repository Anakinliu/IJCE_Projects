package main;

import java.util.Arrays;

/**
 * Author: Anakinliu
 * Date: 2018/03/19
 * Time: 12:53
 * You may be disappointed if you fail,
 * but you are doomed if you don't try.
 */

/*
给一个数组 nums 写一个函数将 0 移动到数组的最后面，非零元素保持原数组的顺序

注意事项
1.必须在原数组上操作
2.最小化操作数

样例
给出 nums = [0, 1, 0, 3, 12], 调用函数之后, nums = [1, 3, 12, 0, 0].
 */
public class Quiz539 {
    /**
     * 我自己写的笨方法
     * 为方便测试, 改为静态方法
     * @param nums: an integer array
     * @return: nothing
     */
    public static void moveZeroes(int[] nums) {
        // write your code here
        int l = nums.length;
        int j;
        int n = 0; // 记录值为0的元素的个数
        boolean flag = false; // 是否应该回退i值
        for (int i = 0; i < l; i++) {
            flag = false;
            if (nums[i] == 0) {

                for (j = i; j < l - 1; j++) {
                    int t = nums[j+1];
                    if (t == 0)
                        flag = true;
                    nums[j+1] = nums[j];
                    nums[j] = t;
                }
                n++;
            }
            if (flag) {
                i--;
            }
            if (n >= l)
                break;
        }
    }

    /*
    网站给的答案, 对比之下我的水平是真的菜...
     */
    public static void moveZeroes2(int[] nums) {
        int left = 0, right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
            right++;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,2,0,0,3,0,7,0,0};
        moveZeroes2(nums);
        System.out.println(Arrays.toString(nums));
    }
}
