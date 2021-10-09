package com.leetcode.BinarySearch;

public class Q33 {
    // Search in Rotated Array
    public int search(int[] nums, int target) {
        //停止的条件是前面比他大
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            int pivot = left + (right - left) / 2;

            if (nums[pivot] == target) {
                return pivot;

            } else if ( pivot <= nums.length-2 && nums[pivot+1] == target ) {
                return pivot + 1;
            } else if (nums[pivot] > nums[left]) {

                if (target >= nums[left] && target < nums[pivot]){
                    right = pivot - 1;
                }else{
                    left = pivot + 1;
                }

            } else {

                if (target <= nums[right] && target > nums[pivot]){
                    left = pivot + 1;
                } else {
                    right = pivot - 1;
                }

            }

        }
        return -1;

    }

    public static void main (String[] args) {

    }
}
