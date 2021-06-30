public class Leetcode_167 {
    public static void main(String[] args) {

    }
    public static int[] twoSum(int[] a, int target) {
        int i = 0, j = a.length -1, sum = 0;
        while((i < j)){
            sum = a[i] + a[j];
            if(sum == target){
                return new int[]{i+1, j+1};
            }else if(sum > target){
                j--;
            } else if(sum < target){
                i++;
            }
        }


        return new int[]{};
    }
}
