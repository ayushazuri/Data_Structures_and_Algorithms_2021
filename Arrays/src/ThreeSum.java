import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] a ={-2, -2, -1, -1, -1, 0, 0, 0, 2, 2};
        List<List<Integer>> al = threeSum(a);
        System.out.println(al);
    }

    private static List<List<Integer>> threeSum(int[] a) {
        Arrays.sort(a);
        List<List<Integer>> al = new ArrayList<>();

        for(int i = 0; i< a.length-2;i++){
            if(i == 0 || (i > 0 && a[i] != a[i-1])){
                int j = i+1, k = a.length-1, sum = -a[i];
                while(j < k){
                    if(a[j] + a[k] == sum){
                        al.add(Arrays.asList(a[i], a[j], a[k]));

                        while(j < k && a[j] == a[j+1]) j++;
                        while(j < k && a[k] == a[k-1]) k--;

                        j++;
                        k--;
                    }
                    else if( a[j] + a[k] > sum) k--;
                    else j++;
                }
            }
        }
        return al;
    }
}
