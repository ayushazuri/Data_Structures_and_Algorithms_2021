/*
* Given an array of distinct integers candidates and a target integer target,
* return a list of all unique combinations of candidates where the chosen numbers sum to target.
* You may return the combinations in any order.
* The same number may be chosen from candidates an unlimited number of times.
* Two combinations are unique if the frequency of at least one of the chosen numbers is different.
*
* https://leetcode.com/problems/combination-sum/
* */

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] a, int target) {
        List<List<Integer>> res = new ArrayList<>();
        comb(0, a, target, res, new ArrayList<>());
        return res;
    }

    public void comb(int i, int[] a, int target, List<List<Integer>> res, ArrayList<Integer> ds){

        if(i == a.length){
            if(target == 0){
                res.add(new ArrayList<>(ds));
            }
            return;
        }

        if(a[i] <= target){
            ds.add(a[i]);
            comb(i, a, target - a[i], res, ds);
            ds.remove(ds.size()-1);
        }
        comb(i+1, a, target, res, ds);
    }
}
