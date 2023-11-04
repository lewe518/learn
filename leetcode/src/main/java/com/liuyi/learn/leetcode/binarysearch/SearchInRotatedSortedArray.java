package com.liuyi.learn.leetcode.binarysearch;

/**
 * 33. Search in Rotated Sorted Array
 * <p>
 * There is an integer array nums sorted in ascending order (with distinct values).
 * Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
 * Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * @author xc_liuyi
 * Create at: 2023/4/9
 */
public class SearchInRotatedSortedArray {
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
