/*There is an integer array nums sorted in ascending order (with distinct values).

        Prior to being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

        Given the array nums after the rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

        You must write an algorithm with O(log n) runtime complexity.

        https://leetcode.com/problems/search-in-rotated-sorted-array/
        */

public class SearchInRotatedArray {
    public int search(int[] a, int target) {
        int l = 0, h = a.length-1;
        while(l <= h){
            int mid = (l+h)>>1;
            if(a[mid] == target) return mid;

            if(a[mid] >= a[l]){
                if(a[mid] >= target && a[l] <= target)
                    h = mid - 1;
                else
                    l = mid + 1;
            }else{
                if(a[mid] <= target && a[h] >= target)
                    l = mid + 1;
                else
                    h = mid - 1;
            }
        }
        return -1;
    }
}
