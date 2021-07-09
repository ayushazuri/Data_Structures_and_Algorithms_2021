import java.util.LinkedList;
import java.util.Stack;

public class DFS {
    public int v;
    public LinkedList<Integer> list[];
    public DFS(int v){
        this.v = v;
        list = new LinkedList[v];
        for(int i = 0;i < v;i++){
            list[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int destination){
        list[source].add(destination);
        list[destination].add(source);
    }

    public void dfs(int source){
        boolean[] check = new boolean[list.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(source);
//        check[source] = true;

        while(!stack.isEmpty()){
            int temp = stack.pop();
            if(!check[temp]){
                check[temp] = true;
                System.out.println(temp);
                for (int dest: list[temp]){
                    stack.push(dest);
                }
            }
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

    public static void main(String[] args) {
        DFS graph = new DFS(5);
        graph.addEdge(0,1 );
        graph.addEdge(0,4 );
        graph.addEdge(1, 2 );
        graph.addEdge(1, 3);
        graph.addEdge(1, 4 );
        graph.addEdge(2, 3 );
        graph.addEdge(3, 4 );
//        graph.addEdge(0, 1);
//        graph.addEdge(0, 2);
//        graph.addEdge(1, 2);
//        graph.addEdge(2, 3);

        graph.print();
        graph.dfs(0);
    }
}
