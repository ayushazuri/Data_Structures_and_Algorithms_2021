/*Given an array of size n that has the following specifications:

        Each element in the array contains either a policeman or a thief.
        Each policeman can catch only one thief.
        A policeman cannot catch a thief who is more than K units away from the policeman.
        We need to find the maximum number of thieves that can be caught.*/
//https://www.geeksforgeeks.org/policemen-catch-thieves/

import java.util.ArrayList;

public class PoliceCatchingThieve {
    public static void main(String[] args) {
        char[] arr = { 'P', 'T', 'T', 'P', 'T' };
        int n = arr.length;
        int k = 2;
        System.out.println("Maximum thieves caught: "
                + policeThief(arr, n, k));
        char arr2[] =new char[] { 'T', 'T', 'P', 'P',
                'T', 'P' };
        k = 2;
        n = arr2.length;
        System.out.println("Maximum thieves caught: "
                +policeThief(arr2, n, k));

        char arr3[] = new char[]{ 'P', 'T', 'P', 'T',
                'T', 'P' };
        k = 3;
        n = arr3.length;
        System.out.println("Maximum thieves caught: "
                +policeThiefBetter(arr3, n, k));
    }

    private static int policeThief(char[] arr, int n, int k) { //Time: O(n) && Space: O(n)
        ArrayList<Integer> pol = new ArrayList<>();
        ArrayList<Integer> thi = new ArrayList<>();

        for(int i=0;i<n;i++){
            if(arr[i] == 'P')
                pol.add(i);
            else if(arr[i] == 'T')
                thi.add(i);
        }

        int i=0, j=0, res=0;
        while(i < pol.size() && j < thi.size()){
            if(Math.abs(pol.get(i) - thi.get(j)) <= k){
                res++;
                i++;
                j++;
            }else if(thi.get(j) < pol.get(i))
                j++;
            else
                i++;
        }
        return res;
    }

    private static int policeThiefBetter(char[] arr, int n, int k) {
        int pol = -1, thi = -1, res = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 'P') {
                pol = i;
                break;
            }
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] == 'T') {
                thi = i;
                break;
            }
        }

        if(pol == -1 || thi == -1)
            return 0;

        while(pol < n && thi < n){
            if(Math.abs(pol - thi) <= k){
                res++;

                pol++;
                while(pol < n && arr[pol] != 'P')
                    pol++;

                thi++;
                while(thi < n && arr[thi] != 'T')
                    thi++;

            }else if(thi < pol){
                thi++;
                while(thi < n && arr[thi] != 'T')
                    thi++;
            }else{
                pol++;
                while(pol < n && arr[pol] != 'P')
                    pol++;
            }
        }
        return res;
    }
}
