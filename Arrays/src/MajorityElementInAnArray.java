// Find if the frequency of the most occurring element in an array is more than half of the length of the array or not.
//    1. Brute force
//    2. Sorting Technique
//    3. Using Hashmap
//    4. Moore's Voting Algorithm

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElementInAnArray {
    public static void main(String[] args) {
        int[] a = {5, 1, 4, 1, 1, 2, 2, 2, 2, 2, 2};
//        a = new int[]{2, 2, 2, 2};
//        a = new int[]{1, 1, 3, 3};
        int res1 = bruteMethod(a);
        System.out.println(res1);
        int res2 = sortingMethod(a);
        System.out.println(res2);
        int res3 = usingMap(a);
        System.out.println(res3);
        int res4 = mooreVotingAlgorithm(a);
        System.out.println(res4);
    }

    public static int bruteMethod(int[] a){ // Time complexity O(n2) and Space Complexity O(1)
        int n = a.length;
        int res = 0;
        int maxFreq = 0;
        for (int i : a) {
            int freq = 0;
            for (int j : a) {
                if (i == j) {
                    freq++;
                }
            }
            if (freq > maxFreq) {
                res = i;
                maxFreq = freq;
            }
        }
        System.out.println("Max frequency "+maxFreq);
        if(maxFreq > n/2)
            return res;
        return -1;
    }

    public static int sortingMethod(int[] a){ // Time complexity: O(nlogn) and Space Complexity O(1)
        if(a == null || a.length == 0 )
            return -1;

        int n = a.length;
        Arrays.sort(a);
        int res = -1, maxFreq = 0;
        int current = -1, freq = 0;


        for(int i: a){
            if(current == i){
                freq++;
            }else{
                if(freq >= maxFreq){
                    maxFreq = freq;
                    res = current;
                }
                freq = 1;
                current  = i;
            }
            if(freq >= maxFreq){
                maxFreq = freq;
                res = current;
            }
        }
        System.out.println("Max frequency "+maxFreq);
        if(maxFreq > n/2)
            return res;
        return -1;
    }

    public static int usingMap(int[] a){ // Time complexity: O(n) and Space Complexity O(n)
        if(a == null || a.length == 0 )
            return -1;

        Map<Integer, Integer> map = new HashMap<>();
        for(int i: a){
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        //Traversing
        int maxFreq = 0, res = -1;
        for(Map.Entry<Integer, Integer> e: map.entrySet()){
            if(e.getValue() > maxFreq){
                maxFreq = e.getValue();
                res = e.getKey();
            }
//            System.out.println(e.getKey() + " " + e.getValue());
        }
        System.out.println("Max frequency "+maxFreq);
        if(maxFreq > a.length/2)
            return res;
        return -1;
    }

    public static int mooreVotingAlgorithm(int[] a){ // Time complexity: O(n) and Space Complexity O(1)
        int ansIndex = 0;
        int count = 1, n = a.length;

        for(int i=1;i<n;i++){
            if(a[i] == a[ansIndex])
                count++;
            else
                count--;

            if(count == 0){
                ansIndex = i;
                count = 1;
            }
        }
        count = 0;
        for(int i: a){
            if(i == a[ansIndex])
                count++;
        }
        System.out.println("Max frequency "+count);
        if(count > n/2)
            return a[ansIndex];
        return -1;
    }
}
