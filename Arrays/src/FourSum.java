//https://leetcode.com/problems/4sum/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> al = new ArrayList<>();
        if(nums == null || nums.length == 0)
            return al;

        int n = nums.length;
        Arrays.sort(nums);

        for(int i = 0; i< n; i++){
            if(i != 0 && nums[i] == nums[i-1]){
                continue;
            }
            for(int j = i + 1; j < n; j++){
                if(j != i+1 && nums[j] == nums[j-1]){
                    continue;
                }
                int l = j + 1, h = n - 1;
                int sum = target - nums[i] - nums[j];
                while(l < h){

                    if( nums[l] + nums[h] > sum) h--;
                    else if(nums[l] + nums[h] < sum) l++;
                    else{
                        ArrayList<Integer> quad = new ArrayList<>();
                        quad.add(nums[i]);
                        quad.add(nums[j]);
                        quad.add(nums[l]);
                        quad.add(nums[h]);

                        al.add(quad);

                        while(l < h && nums[l] == quad.get(2)) l++;
                        while(l < h && nums[h] == quad.get(3)) h--;
                    }
                }
            }
        }
        return al;
    }
}
