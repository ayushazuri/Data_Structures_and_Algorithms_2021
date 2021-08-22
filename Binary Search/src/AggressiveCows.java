//https://www.youtube.com/watch?v=wSOfYesTBRk&ab_channel=takeUforward
//Arrange cows in such a way that they are apart from each other. Find the largest dist(minimum of the distances among the cows) such that cows are
// far from each other.

import java.util.Arrays;

public class AggressiveCows {
    public static void main(String[] args) {
        int[] a = {1, 2, 4, 8, 9};
        int cows = 3;
        System.out.println(largestMin(a, cows, a.length));
    }

    private static int largestMin(int[] a, int cows, int len) {
        Arrays.sort(a);
        int res = Integer.MIN_VALUE;
        int low = 1, high = a[len - 1] - a[0];
        while(low <= high){
            int mid = (low + high)>>1;
            if(canPlace(a, cows, mid, len)){
                res = mid;
                low = mid + 1;
            }else
                high = mid - 1;
        }
        return res;
    }

    private static boolean canPlace(int[] a, int cows, int mid, int len) {
        int coordinate = a[0], count = 1;
        for(int i =1;i<len;i++){
            if(a[i]-coordinate >= mid){
                count++;
                coordinate=a[i];
            }

        }
        if(count == cows) return true;
        return false;
    }
}
