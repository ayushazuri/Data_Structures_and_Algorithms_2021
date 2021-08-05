/*
* Given an array having both positive and negative integers. The task is to compute the length of the largest subarray with sum 0.
* https://practice.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1#
* */

import java.util.HashMap;
import java.util.Scanner;

public class largestSubarrayWithZeroSum {
    public static void main(String arg[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();


            System.out.println(maxLen(arr, n));
            T--;
        }
    }
    static int maxLen(int arr[], int n)
    {
        // Your code here
        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0, max = 0;
        for(int i = 0; i < n; i++){
            sum += arr[i];
            if(sum == 0){
                max = i + 1;
            }else{
                if(map.get(sum) != null){
                    max = Math.max(max, i - map.get(sum));
                }else{
                    map.put(sum, i);
                }
            }
        }
        return max;
    }
}
