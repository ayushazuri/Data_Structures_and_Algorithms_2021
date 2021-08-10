import java.util.*;

public class KahnAlgoTopo {
    public LinkedList<Integer> list[];
    public int v;
    public KahnAlgoTopo(int v){
        this.v = v;
        list = new LinkedList[v];
        for(int i = 0;i < v;i++){
            list[i] = new LinkedList<>();
        }
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
    public void addEdge(int u, int v){
        list[u].add(v);
    }

    public ArrayList<Integer> TopoSort(){
        ArrayList<Integer> topo = new ArrayList<>();
        int[] inDegree = new int[v];

        for(int i=0;i<v;i++){
            for(int j: list[i]){
                inDegree[j]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<v;i++){
            if(inDegree[i] == 0)
                queue.add(i);
        }

        while(!queue.isEmpty()){
            int temp = queue.poll();
            topo.add(temp);
            for(int i: list[temp]){
                inDegree[i]--;
                if(inDegree[i] == 0)
                    queue.add(i);
            }
        }
        return topo;
    }
    public static void main(String[] args) {
        KahnAlgoTopo graph = new KahnAlgoTopo(6);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(5, 0);
        graph.addEdge(5, 2);
//        graph.print();

        ArrayList<Integer> topoSort = graph.TopoSort();
        System.out.println(topoSort);


    }
}
