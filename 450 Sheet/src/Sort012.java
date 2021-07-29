import java.util.Arrays;

public class Sort012 {
    public static void main(String[] args) {
        int [] a = {1, 2, 0, 2, 1, 1, 2, 0, 0, 0, 1, 2};
        a = sort012(a);
        System.out.println(Arrays.toString(a));
    }

    private static int[] sort012(int[] a) {
        int low = 0, mid = 0, high = a.length-1;
        while(mid <= high){
            switch(a[mid]){
                case 0: {
                    int t = a[low];
                    a[low] = a[mid];
                    a[mid] = t;
                    low++;
                    mid++;
                    break;
                }
                case 1:{
                    mid++;
                    break;
                }
                case 2: {
                    int t = a[high];
                    a[high] = a[mid];
                    a[mid] = t;
                    high--;
                }
            }
        }
        return a;
    }
}
