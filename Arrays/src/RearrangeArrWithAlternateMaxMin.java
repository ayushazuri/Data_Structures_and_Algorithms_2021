import java.util.Arrays;

public class RearrangeArrWithAlternateMaxMin {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6};
        rearrange(a, a.length);
        System.out.println(Arrays.toString(a));
    }

    public static void rearrange(int[] a, int n){
        int minInd = 0;
        int maxInd = n - 1;
        int max = a[n - 1] + 1;

        for(int i = 0;i < n;i++){
            if(i % 2 == 0){
                a[i] += (a[maxInd]%max)*max;
                maxInd--;
            }
            else{
                a[i] += (a[minInd]%max)*max;
                minInd++;
            }
        }

        for(int i = 0;i < n;i++){
            a[i] = a[i]/max;
        }
    }
}
