import java.util.ArrayList;
import java.util.LinkedList;

public class MaximumOfSubarraySizeK {
    public static void main(String[] args) {
        int[] a = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.println(maximum(a, k));
    }

    static ArrayList<Integer> maximum(int[] a, int k){
        ArrayList<Integer> res = new ArrayList<>();
        LinkedList<Integer> window = new LinkedList<>();
        int i=0,j=0;
        while(j < a.length){
            if(!window.isEmpty() && window.getFirst() < a[j]){
                window.clear();
            }
            window.add(a[j]);
            if(j-i+1 < k)
                j++;
            else{
                res.add(window.getFirst());

                if(window.getFirst() == a[i])
                    window.removeFirst();
                i++;
                j++;
            }
        }
        return res;
    }
}
