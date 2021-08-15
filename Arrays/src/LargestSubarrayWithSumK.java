public class LargestSubarrayWithSumK {
    public static void main(String[] args) {
        int[] a = {4, 1, 1, 1, 2, 3, 5};
        int k = 5;
        System.out.println(maxLenSlidingWindow(a, k));
    }
    static int maxLenSlidingWindow(int[] a, int k){ //doesn't work for negative elements, use HashMap
        int i=0,j=0, sum=0, max=0;

        while(j < a.length){
            sum += a[j];
            if(sum == k){
                max = Math.max(max, j-i+1);
                for(int t=i;t<=j;t++)
                    System.out.print(a[t]+" ");
                System.out.println();
                j++;
            }
            else if(sum < k){
                j++;
            }else if(sum > k){
                while(sum > k){
                    sum -= a[i];
                    i++;
                }
                if(sum == k){
                    max = Math.max(max, j-i+1);
                    for(int t=i;t<=j;t++)
                        System.out.print(a[t]+" ");
                    System.out.println();
                }
                j++;
            }
        }
        return max;
    }
}
