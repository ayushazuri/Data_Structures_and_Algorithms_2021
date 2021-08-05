/*
* Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.
*
* https://leetcode.com/problems/longest-consecutive-sequence/
*/


import java.util.HashSet;
public class LongestConsecutiveSubsequence {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i: nums){
            set.add(i);
        }

        int lng = 0;
        for(int i: nums){
            if(!set.contains(i - 1)){
                int curr = i;
                int c = 1;
                while(set.contains(curr+1)){
                    curr++;
                    c++;
                }

                lng = Math.max(lng, c);
            }
        }
        return lng;
    }
}
