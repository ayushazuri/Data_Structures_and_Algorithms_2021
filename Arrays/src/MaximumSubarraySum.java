//Find the largest sum of a contagious subarray present in an array.
//    1. Brute Force
//    2. Kadane's Algorithm

public class MaximumSubarraySum {
    public static void main(String[] args) {
        int[] a = {-5, 4, 6, -3, 4, -1};

        System.out.println(bruteForce(a));
        System.out.println(kadaneAlgorithm(a));
    }

    public static int bruteForce(int[] a){ //Time Complexity O(n2) and Space Complexity O(1)
        int n = a.length;
        int maxSum = Integer.MIN_VALUE;
        for(int i = 0;i<n;i++){
            int sum = 0;
            for(int j=i;j<n;j++){
                sum += a[j];
                maxSum = Math.max(sum, maxSum);
            }
        }
        return maxSum;
    }

    public static int kadaneAlgorithm(int[] a) { //Time Complexity O(n) and Space Complexity O(1)
        int maxSum = Integer.MIN_VALUE, currSum = 0;
        for(int i: a){
            currSum += i;
            maxSum = Math.max(currSum, maxSum);

            if(currSum < 0)
                currSum = 0;
        }
        return maxSum;
    }
}

// Explanation : Keep adding all contagious elements, if the sum comes out to be negative, discard the sum as it will only provide negative sum or lower the total sum
// and start fresh from that point. As the earlier subarray wont be counted. so now start from sum = 0 and check if the new sum is greater than the max sum or not.