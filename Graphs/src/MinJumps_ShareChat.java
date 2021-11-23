import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// BFS Approach for minimum jumps.
//Question Asked in Sharechat

public class MinJumps_ShareChat {
    static class Pair{
        int index;
        int value;
        int dist;
        ArrayList<Integer> path;
        Pair(int i, int v, int d){
            index = i;
            value = v;
            dist = d;
        }
    }
    public static void main(String[] args) {
        int[] arr = {1, 3, 1, 2, 0, 2, 6, 7, 6, 0, 9};
        System.out.println(minJumps(arr));
    }

    public static int minJumps(int[] arr){
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, arr[0], 0));
        Pair temp = new Pair(0,0,0);
        while(!queue.isEmpty()){
            temp = queue.poll();
            int value = temp.value;
            int dist = temp.dist;

            if(temp.index == arr.length - 1)
                return dist;

                for(int i= temp.index+1; i<=temp.index+value && i < arr.length;i++){
                if(arr[i] == 0)
                    continue;
                Pair jump = new Pair(i, arr[i], dist+1);
                jump.path.add(arr[i]);
                queue.add(jump);
            }
        }
        if(temp.index != arr.length -1)
            return -1;

        return -1;
    }
}
