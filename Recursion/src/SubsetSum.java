//Given a list arr of N integers, print sums of all subsets in it. Output should be printed in increasing order of sums.
//https://practice.geeksforgeeks.org/problems/subset-sums2234/1

import java.util.ArrayList;
import java.util.Collections;


public class SubsetSum {
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        // code here
        ArrayList<Integer> sumSub = new ArrayList<>();
        func(0, 0, arr, sumSub, N);
        Collections.sort(sumSub);
        return sumSub;
    }

    void func(int i, int sum, ArrayList<Integer> arr, ArrayList<Integer> sumSub, int n){
        if(i == n){
            sumSub.add(sum);
            return;
        }

        func(i+1, sum+arr.get(i), arr, sumSub, n);
        func(i+1, sum, arr, sumSub, n);
    }
}
