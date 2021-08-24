//https://www.youtube.com/watch?v=2JzRBPFYbKE&list=PLgUwDviBIf0rPG3Ictpu74YWBQ1CaBkm2&index=7&ab_channel=takeUforward

import java.util.ArrayList;
import java.util.List;

public class MergeIntervals {
    public static int[][] merge(int[][] a){
        List<int[]> res = new ArrayList<>();

        int start = a[0][0], end = a[0][1];
        for(int[] i: a){
            if(i[0] <= end){
                end = Math.max(i[1], end);
            }else{
                res.add(new int[]{start, end});
                start = i[0];
                end = i[1];
            }
        }
        res.add(new int[]{start, end});
        return res.toArray(new int[0][]);
    }
}
