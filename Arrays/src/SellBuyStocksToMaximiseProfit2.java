/*You are given an array prices where prices[i] is the price of a given stock on the ith day.

Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).

Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).*/

public class SellBuyStocksToMaximiseProfit2 {
    public static void main(String[] args) {
        int[] a = {7,1,5,3,6,4};
        int profit = 0;
        for(int i=1;i<a.length; i++){
            if(a[i] > a[i-1])
                profit += a[i] - a[i-1];
        }
        System.out.println(profit);
    }
}
