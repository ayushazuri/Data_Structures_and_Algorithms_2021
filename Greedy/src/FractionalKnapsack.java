//Given weights and values of N items, we need to put these items in a knapsack of capacity W to get the maximum total value in the knapsack.
//https://practice.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1

import java.util.Arrays;

import java.util.Comparator;

public class FractionalKnapsack {
    class Item {
        int value, weight;
        Item(int x, int y){
            this.value = x;
            this.weight = y;
        }
    }

    class itemComp implements Comparator<Item> {
        @Override
        public int compare(Item a, Item b){
            double r1 = (double)a.value/(double)a.weight;
            double r2 = (double)b.value/(double)b.weight;

            if(r1 < r2) return 1;
            else if(r1 > r2) return -1;
            else return 0;
        }
    }

    double fractionalKnapsack(int W, Item arr[], int n)
    {
        // Your code here
        Arrays.sort(arr, new itemComp());
        int curr = 0;
        double res = 0.0;

        for(int i = 0;i<arr.length;i++){
            if(curr + arr[i].weight <= W){
                curr += arr[i].weight;
                res += arr[i].value;
            }else{
                int rem = W - curr;
                res += ((double)arr[i].value/(double)arr[i].weight)*(double)rem;
                break;
            }
        }
        return res;
    }
}
