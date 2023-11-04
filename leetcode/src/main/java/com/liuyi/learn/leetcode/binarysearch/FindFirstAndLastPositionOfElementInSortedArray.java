package com.liuyi.learn.leetcode.binarysearch;

/**
 * 34. Find First and Last Position of Element in Sorted Array
 * <p>
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
 * If target is not found in the array, return [-1, -1].
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * @author xc_liuyi
 * Create at: 2023/4/9
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        // 找到target对应的索引
        int targetIndex = -1;
        while (left <= right) {
            int middle = (right + left) >>> 1;
            // 相等则返回结果
            if (nums[middle] == target) {
                targetIndex = middle;
                break;
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
        // 没有找到target
        if (targetIndex == -1) {
            return new int[] {-1, -1};
        }

        // 根据target的索引位置，找到前后位置的结果
        left = targetIndex;
        right = targetIndex;
        while (left > 0) {
            // 索引前移直到找到非target的值
            if (nums[left - 1] != target) {
                break;
            }
            left -= 1;
        }


        while (right < nums.length - 1) {
            // 索引后移直到找到非target的值
            if (nums[right + 1] != target) {
                break;
            }
            right += 1;
        }

        return new int[] {left, right};
    }
}
