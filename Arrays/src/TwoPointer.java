import java.util.Arrays;

public class TwoPointer {
    public static void main(String[] args) {
        int[] a = {2, 7, 11, 15};
        int target = 9;
        int[] res = twoSum(a, target);
        System.out.println(Arrays.toString(res));
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
