//https://www.youtube.com/watch?v=LuLCLgMElus&list=PLgUwDviBIf0rPG3Ictpu74YWBQ1CaBkm2&index=12&ab_channel=takeUforward
/*
    1) If all digits sorted in descending order, then output is always “Not Possible”. For example, 4321.
    2) If all digits are sorted in ascending order, then we need to swap last two digits. For example, 1234.
    3) For other cases, we need to process the number from rightmost side
*/
import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        int[] a = {1, 2, 5, 4, 3, 2};
        nextPermutation(a);
        System.out.println(Arrays.toString(a));
    }
    public static void nextPermutation(int[] a){
        if(a == null || a.length <= 1) return;

        int i = a.length-2;

        while(i >= 0 && a[i] >= a[i+1]) i--;

        if(i >= 0){
            int j = a.length-1;
            while(a[i] >= a[j]) j--;
            swap(a, i, j);
        }
        reverse(a, i + 1, a.length-1);
    }

    private static void reverse(int[] a, int i, int j) {
        while(i<j) swap(a, i++, j--);
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
