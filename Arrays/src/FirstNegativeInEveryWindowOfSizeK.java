import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class FirstNegativeInEveryWindowOfSizeK {
    public static void main(String[] args) {
        int[] a = {12, -1, -7, 4, -5, 8, -4};
        ArrayList<Integer> al = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        int i = 0, j = 0, k = 3;
        while(j < a.length){
            if(a[j] < 0)
                q.add(a[j]);

            if(j - i + 1< k)
                j++;
            else if(j - i + 1 == k){
                if(!q.isEmpty())
                    al.add(q.peek());
                else
                    al.add(0);

                if(a[i] == q.element())
                    q.poll();

                i++;
                j++;
            }
        }

        System.out.println(al);
    }
}
