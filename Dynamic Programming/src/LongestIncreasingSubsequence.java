//https://www.youtube.com/watch?v=odrfUCS9sQk&ab_channel=Pepcoding
//The Longest Increasing Subsequence (LIS) problem is to find the length of the longest subsequence of a given sequence such that all elements of
// the subsequence are sorted in increasing order. For example, the length of LIS for {10, 22, 9, 33, 21, 50, 41, 60, 80} is 6 and
// LIS is {10, 22, 33, 50, 60, 80}.
//https://www.geeksforgeeks.org/longest-increasing-subsequence-dp-3/

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] a = {10, 22, 9, 33, 21, 50, 41, 60, 80, 1};
        System.out.println(longestIncreasing(a));
    }

    private static int longestIncreasing(int[] a) {
        int[] dp = new int[a.length];
        int maxValue = 0;
        for(int i=0;i<a.length;i++){
            int val = 0;
            for(int j = 0;j<i;j++){
                if(a[i]>a[j])
                    val = Math.max(val, dp[j]);
            }
            dp[i] = val + 1;
            maxValue = Math.max(dp[i], maxValue);
        }
        return maxValue;
    }
}
