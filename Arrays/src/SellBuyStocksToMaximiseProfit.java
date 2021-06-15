/*
Buy and sell a stock in such a way that the profit becomes maximum.
    1. Make a new array which will contain all the maximum elements(Greatest to the right) for each element and then subtract the two arrays to get the difference.class
    2. maintain two variables, minSoFar(best day to buy) and maxProfit. go through all element with the sense of selling the stock, and maintain the minsofar variable
       and check if the difference is max or not.
*/

public class SellBuyStocksToMaximiseProfit {
    public static void main(String[] args) {
        int[] a = {3, 1, 4, 8, 7, 2, 5};
        int[] b = {5, 2, 6, 1, 4};
        System.out.println(secondMethod(a));
        System.out.println(secondMethod(b));
    }

    public static int secondMethod(int[] a){ //Time Complexity O(n) Space Complexity O(1)
        int minSoFar = a[0], maxProfit = Integer.MIN_VALUE;

        for(int i: a){
            maxProfit = Math.max(maxProfit, i - minSoFar);
            minSoFar = Math.min(i, minSoFar);
        }
        return maxProfit;
    }
}
