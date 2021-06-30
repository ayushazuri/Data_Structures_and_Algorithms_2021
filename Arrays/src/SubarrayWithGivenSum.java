import java.lang.reflect.Array;
import java.util.ArrayList;

public class SubarrayWithGivenSum {
    public static void main(String[] args) {
        int a[] = {2, 3, 4, 5, 6, 2};
        int target = 15;
        ArrayList<Integer> al = subarraySum(a, a.length, target);
        System.out.println(al);
    }

    static ArrayList<Integer> subarraySum(int[] arr, int n, int s)
    {
        int i = 0, j = 0;
        int sum = 0;

        while(j < n){
            if(sum == s){
                break;
            }else if(sum > s){
                sum -= arr[i];
                i++;
            }else if(sum < s){
                sum += arr[j];
                j++;
            }
        }
        ArrayList<Integer> al = new ArrayList<>();
        al.add(i+1);
        al.add(j);
        return al;
    }
}
