//There are n houses build in a line, each of which contains some value in it.
// A thief is going to steal the maximal value of these houses, but he can’t steal in two adjacent houses because
// the owner of the stolen houses will tell his two neighbors left and right side. What is the maximum stolen value?
// https://www.geeksforgeeks.org/find-maximum-possible-stolen-value-houses/

public class MaxStolenHouse {
    public static void main(String[] args) {
        int a[] = {6, 7, 1, 3, 8, 2, 4};
//        int[] a = {5, 3, 4, 11, 2};
        int n = a.length;
        System.out.println(maxStolen(a, n-1));
    }

    public static int maxStolen(int a[], int n){
        if(n < 0) return 0;
        if(n == 0) return a[0];
        if(n == 1) return Integer.max(a[1], a[0]);

        return Math.max(a[n] + maxStolen(a, n-2), maxStolen(a, n-1));
    }
    public static int maxStolenDp(int hval[], int n){
        if (n == 0)
            return 0;
        if (n == 1)
            return hval[0];
        if (n == 2)
            return Math.max(hval[0], hval[1]);

        int[] dp = new int[n+1]; //because from function calling we are sending n-1
        dp[0] = hval[0];
        dp[1] = Math.max(hval[0], hval[1]);

        for (int i = 2; i<n; i++)
            dp[i] = Math.max(hval[i]+dp[i-2], dp[i-1]);

        return dp[n-1];

    }
    public static int maxStolenBest(int hval[], int n){
        if (n == 0)
            return 0;

        int value1 = hval[0];
        if (n == 1)
            return value1;

        int value2 = Math.max(hval[0], hval[1]);
        if (n == 2)
            return value2;

        // contains maximum stolen value at the end
        int max_val = 0;

        // Fill remaining positions
        for (int i=2; i<n; i++)
        {
            max_val = Math.max(hval[i]+value1, value2);
            value1 = value2;
            value2 = max_val;
        }

        return max_val;
    }
}
