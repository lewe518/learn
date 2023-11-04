package com.liuyi.learn.leetcode.binarysearch;

/**
 * 704. BinarySearch
 * <p>
 * Given an array of integers nums which is sorted in ascending order, and an integer target,
 * write a function to search target in nums.
 * If target exists, then return its index. Otherwise, return -1.
 * <p>
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * @author xc_liuyi
 * Create at: 2023/4/8
 */
public class BinarySearch {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = (right + left) >>> 1;
            // 相等则返回结果
            if (nums[middle] == target) {
                return middle;
            }
            // 大于目标值，则只可能在[left,middle)中
            else if (nums[middle] > target) {
                right = middle - 1;
            }
            // 小于目标值，则只可能在(middle,right]中
            else {
                left = middle + 1;
            }
        }

        return -1;
    }
}
