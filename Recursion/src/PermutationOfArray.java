/*
* Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
* https://leetcode.com/problems/permutations/
* */

import java.util.ArrayList;
import java.util.List;

public class PermutationOfArray {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        per(0, nums, res);
        return res;
    }

    public void per(int index, int[] nums, List<List<Integer>> res){

        if(index == nums.length){
            ArrayList<Integer> al = new ArrayList<>();
            for(int i: nums){
                al.add(i);
            }
            res.add(al);
            return;
        }

        for(int i = index; i < nums.length;i++){
            swap(index, i, nums);
            per(index + 1, nums, res);
            swap(index, i, nums);
        }
    }

    public void swap(int i, int j, int[] nums){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
