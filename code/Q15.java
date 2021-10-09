package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Q15 {
    //3Sum
    public List<List<Integer>> threeSum(int[] nums) {


        List<List<Integer>> ls = new ArrayList<List<Integer>>(); //O(1)

        Arrays.sort(nums); //O(nlongn)

        // //adding sorted nums to hashset
        // for(int i = 0; i < nums.length; i++){ // O(1) * O(n) = O(n)
        //     hs.add(nums[i]);                  // O(1)
        // }

        for(int i = 0; i < nums.length && nums[i] <= 0; i++){
            if(i == 0 || nums[i] != nums[i-1]){
                twosum(nums, i , ls);
            }
        }
        return ls;

    }
    public void twosum(int[] nums, int i, List<List<Integer>> ls){
        HashSet<Integer> hs = new HashSet<Integer>();//O(1)

        for(int j = i+1; j < nums.length; j++){
            int numberC = -nums[i] -nums[j];
            // if((numberC != -nums[i] && numberC != -nums[j] && nums[i] != nums[j] && numberC != nums[j]) ||
            //   (numberC == 0 && nums[i] == 0 && nums[j] == 0)){
            if(hs.contains(numberC)){
                ls.add(Arrays.asList(nums[i],nums[j],numberC));
                while(j+1 < nums.length && nums[j] == nums[j+1]){
                    j++;
                }
            }hs.add(nums[j]);
        }
    }
}
