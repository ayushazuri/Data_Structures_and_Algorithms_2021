//https://leetcode.com/problems/remove-element/

public class Leetcode_27 {
    public static void main(String[] args) {
    int[] nums = {0,1,2,2,3,0,4,2};
    int val = 2;

    System.out.println(removeElement(nums, val));
    }

    public static int removeElement(int[] nums, int val) {
         int i = 0, t = nums.length-1;
         if(t <= 0) return 0;

         while(i <= t){
             if(nums[i] == val){
                 int k = nums[t];
                 nums[t] = nums[i];
                 nums[i] = k;
                 t--;
             }else{
                 i++;
             }
         }
         for(int a: nums){
             System.out.print(a+ " ");
         }
         return i;

    }
}
