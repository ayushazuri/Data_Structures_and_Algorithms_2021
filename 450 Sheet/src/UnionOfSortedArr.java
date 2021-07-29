import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UnionOfSortedArr {
    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 2, 2, 3 };
        int[] arr2 = { 2, 3, 4, 5 };

//        union(arr1, arr2);
        unionWithArray(arr1, arr2);
    }

    private static void unionWithArray(int[] arr1, int[] arr2) {
        int n1 = arr1[arr1.length-1];
        int n2 = arr2[arr2.length-1];

        int max = Math.max(n1, n2);
        int[] arr = new int[max+1];
        Arrays.fill(arr, 0);
        System.out.println(arr1[0]);
        arr[arr1[0]]++;
        for(int i = 1;i<arr1.length;i++){
            if(arr1[i] != arr1[i-1]){
                System.out.println(arr1[i]);
                arr[arr1[i]]++;
            }
        }

        for(int i = 0;i<arr2.length;i++){
            if(arr[arr2[i]] == 0){
                System.out.println(arr2[i]);
                arr[arr2[i]]++;
            }
        }
    }

    private static void union(int[] arr1, int[] arr2) { // O(2n) with extra space
        Set<Integer> set = new HashSet<>();
        for(int i: arr1){
            if(!set.contains(i)){
                set.add(i);
                System.out.println(i);
            }
        }
        for(int i: arr2){
            if(!set.contains(i)){
                set.add(i);
                System.out.println(i);
            }
        }
    }


}
