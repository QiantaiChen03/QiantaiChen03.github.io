package com.leetcode;

import java.util.HashSet;

public class Q349 {
    //Intersection of Two Arrays
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> hs = new HashSet<>();
        HashSet<Integer> ls = new HashSet<>();
        for (int i = 0; i< nums1.length; i++) {
            hs.add(nums1[i]);
        }

        for(int j = 0; j < nums2.length; j++) {
            if (j > 0 && nums2[j-1] == nums2[j]) {
                continue;
            }
            if (hs.contains(nums2[j])) {
                ls.add(nums2[j]);
            }
        }
        int[] result = new int[ls.size()];
        int i = 0;
        for (Integer ele : ls) {
            result[i++] = ele;
        }
        return result;
    }

    public static void main (String[] args) {

    }
}
