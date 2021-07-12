import java.util.Arrays;
import java.util.LinkedList;

public class CyclicPatternInUndirectedGraph {
    public LinkedList<Integer> list[];
    public int v;
    public CyclicPatternInUndirectedGraph(int v){
        this.v = v;
        list = new LinkedList[v];
        for(int i = 0;i < v;i++){
            list[i] = new LinkedList<>();
        }
    }

    public void addEdge(int u, int v){
        list[u].add(v);
        list[v].add(u);
    }

    public boolean checkForCycle(int node, int parent, boolean[] visited){
        visited[node] = true;
        for(int i: list[node]){
            if(!visited[i])
                if(checkForCycle(i, node, visited))
                    return true;
                else if(i != parent){
                    return true;
                }
        }
        return false;
    }

    public boolean isCyclic(){
        boolean[] visited = new boolean[v];
        Arrays.fill(visited, false);
        for(int i = 0;i < v;i++){
            if(!visited[i])
                if(checkForCycle(i, -1, visited))
                    return true;
        }
        return false;
    }
    public void print(){
        for(int i =0;i<list.length;i++){
            System.out.print(i + "=>");
            for(int j = 0;j<list[i].size();j++){
                System.out.print(list[i].get(j) + "=>");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        CyclicPatternInUndirectedGraph graph = new CyclicPatternInUndirectedGraph(5);
        graph.addEdge(0,1 );
        graph.addEdge(0,4 );
        graph.addEdge(1, 2 );
        graph.addEdge(1, 3);
        graph.addEdge(1, 4 );
        graph.addEdge(2, 3 );
        graph.addEdge(3, 4 );
        graph.print();
        System.out.println(graph.isCyclic());

        CyclicPatternInUndirectedGraph g2 = new CyclicPatternInUndirectedGraph(3);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        g2.print();

        System.out.println(g2.isCyclic());

    }
}
