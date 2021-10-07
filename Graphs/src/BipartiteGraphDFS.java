import java.util.ArrayList;

public class BipartiteGraphDFS {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = 7;
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<Integer>());

        adj.get(0).add(1);
        adj.get(1).add(0);

        adj.get(1).add(2);
        adj.get(2).add(1);

        adj.get(2).add(7);
        adj.get(7).add(2);

        adj.get(4).add(3);
        adj.get(3).add(4);

        adj.get(4).add(5);
        adj.get(5).add(4);

        adj.get(4).add(6);
        adj.get(6).add(4);

        adj.get(1).add(6);
        adj.get(6).add(1);

        System.out.println(adj);
        int[] color = new int[n];
        for(int i = 0;i<n;i++) {
            color[i] = -1;
        }
        System.out.println(checkBipartite(adj, n, color));
        for(int i: color){
            System.out.print(i + " ");
        }
    }

    private static boolean checkBipartite(ArrayList<ArrayList<Integer>> adj, int n, int[] color) {

        for(int i=0;i<n;i++){
            if(color[i] == -1)
                if(!dfsCheck(adj, i, color))
                    return false;
        }
        return true;
    }

    private static boolean dfsCheck(ArrayList<ArrayList<Integer>> adj, int curr, int[] color) {
        if(color[curr] == -1) color[curr] = 1;

        for(Integer i: adj.get(curr)){
            if(color[i] == -1){
                color[i] = 1 - color[curr];
                if(!dfsCheck(adj, i, color))
                    return false;
            }else if(color[curr] == color[i]){
                return false;
            }
        }
        return true;
    }
}
