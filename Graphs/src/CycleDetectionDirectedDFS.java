import java.util.Arrays;
import java.util.LinkedList;

public class CycleDetectionDirectedDFS {
    int v;
    LinkedList<Integer>[] list;
    public CycleDetectionDirectedDFS(int v){
        this.v = v;
        list = new LinkedList[v];
        for(int i = 0;i < v;i++){
            list[i] = new LinkedList<>();
        }
    }

    public void addEdge(int u, int v){
        list[u].add(v);
    }

    public boolean isCyclic(){
        int[] visited = new int[v];
        int[] dfsVis = new int[v];
        Arrays.fill(visited, 0);
        Arrays.fill(dfsVis, 0);
        for(int i = 0;i < v;i++){
            if(visited[i] == 0)
                if(checkForCycle(i, visited, dfsVis))
                    return true;
        }
        return false;
    }

    public boolean checkForCycle(int node, int[] vis, int[] dfsVis){
        vis[node] = 1;
        dfsVis[node] = 1;

        for(int i: list[node]){
            if(vis[i] == 0){
                if(checkForCycle(i, vis, dfsVis))
                    return true;
            }else if(dfsVis[i] == 1)
                return true;
        }
        dfsVis[node] = 0;
        return false;
    }
}
