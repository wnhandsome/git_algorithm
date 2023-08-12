package com.w6n.charpter3_array.level1.单调数组;

public class Monotonic {
    public static void main(String[] args) {
        int a[] = {1, 2, 2, 3};
        int testMethod = 1;
//        通过两次遍历来实现
        System.out.println(isMonotonic(a));
//        一次遍历实现
        System.out.println(isMonotonic_2(a));

        StringBuilder sb = new StringBuilder();
        sb.append("\"");
        sb.append(0);
        sb.append("->");
        sb.append(2);
        sb.append("\"");
        System.out.println(sb.toString());
    }

    /**
     * 第一种方法，两次遍历确定，第一次确定是否递增 ，第二次
     *
     * @param nums
     * @return
     */
    public static boolean isMonotonic(int[] nums) {
        return isSorted(nums, true) || isSorted(nums, false);
    }

    public static boolean isSorted(int[] nums, boolean increasing) {
        int n = nums.length;
        for (int i = 0; i < n - 1; ++i) {
            if(increasing){
                if (nums[i] > nums[i + 1]) {
                    return false;
                }
            }else{
                if (nums[i] < nums[i + 1]) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 第二种方式，一次遍历确定
     *如果是递增的就一定不能出现递减的相邻元素，
     * 如果出现递减的就一定不能出现递增的相邻元素。
     * @param nums
     * @return
     */
    public static boolean isMonotonic_2(int[] nums) {
        boolean inc = true, dec = true;
        int n = nums.length;
        for (int i = 0; i < n - 1; ++i) {
            if (nums[i] > nums[i + 1]) {
                inc = false;
            }
            if (nums[i] < nums[i + 1]) {
                dec = false;
            }
        }
        return inc || dec;
    }
}
