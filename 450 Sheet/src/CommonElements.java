//https://practice.geeksforgeeks.org/problems/common-elements1132/1#

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CommonElements {
    public static void main(String[] args) {
        int[] a = {1, 5, 10, 20, 40, 80};
        int[] b = {6, 7, 20, 80, 100};
        int[] c = {3, 4, 15, 20, 30, 70, 80, 120};
        ArrayList<Integer> al = commonElements(a, b, c, a.length, b.length, c.length);
        System.out.println(al);
    }
    static ArrayList<Integer> commonElements(int a[], int b[], int c[], int n1, int n2, int n3) // Try to handle common elements inline only,
    // without using another data structure
    {
        // code here
        int i=0,j=0,k=0;
        ArrayList<Integer> al = new ArrayList<>();

        while(i < a.length && j < b.length && k < c.length){
            if(a[i] == b[j] && b[j] == c[k]){
                if(!al.contains(a[i]))
                    al.add(a[i]);
                i++;
                j++;
                k++;

            }
            else if(a[i] <= b[j] && a[i] <= c[k])
                i++;
            else if(b[j] <= a[i] && b[j] <= c[k])
                j++;
            else if(c[k] <= a[i] && c[k] <= b[j])
                k++;

        }
        return al;
    }
}
