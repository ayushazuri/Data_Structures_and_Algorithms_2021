import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

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
    public static void subArraySum(int[] arr, int n, int sum) {
        //cur_sum to keep track of cummulative sum till that point
        int cur_sum = 0;
        int start = 0;
        int end = -1;
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            cur_sum = cur_sum + arr[i];
            //check whether cur_sum - sum = 0, if 0 it means
            //the sub array is starting from index 0- so stop
            if (cur_sum - sum == 0) {
                start = 0;
                end = i;
                break;
            }
            //if hashMap already has the value, means we already
            // have subarray with the sum - so stop
            if (hashMap.containsKey(cur_sum - sum)) {
                start = hashMap.get(cur_sum - sum) + 1;
                end = i;
                break;
            }
            //if value is not present then add to hashmap
            hashMap.put(cur_sum, i);

        }
        // if end is -1 : means we have reached end without the sum
        if (end == -1) {
            System.out.println("No subarray with given sum exists");
        } else {
            System.out.println("Sum found between indexes "
                    + start + " to " + end);
        }

    }
}
