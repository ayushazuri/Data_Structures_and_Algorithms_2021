import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class CloneGraph {
    static class GraphNode {
        int val;
        LinkedList<GraphNode> neighbours;
        public GraphNode(int val)
        {
            this.val = val;
            neighbours = new LinkedList<>();
        }
    }
    static public GraphNode buildGraph() {
        GraphNode node1 = new GraphNode(1);
        GraphNode node2 = new GraphNode(2);
        GraphNode node3 = new GraphNode(3);
        GraphNode node4 = new GraphNode(4);
        LinkedList<GraphNode> v = new LinkedList<>();
        v.add(node2);
        v.add(node4);
        node1.neighbours = v;
        v = new LinkedList<GraphNode>();
        v.add(node1);
        v.add(node3);
        node2.neighbours = v;
        v = new LinkedList<GraphNode>();
        v.add(node2);
        v.add(node4);
        node3.neighbours = v;
        v = new LinkedList<GraphNode>();
        v.add(node3);
        v.add(node1);
        node4.neighbours = v;
        return node1;
    }

    static GraphNode cloneGraph(GraphNode source){
        Queue<GraphNode> queue = new LinkedList<>();
        queue.add(source);
        HashMap<GraphNode, GraphNode> map = new HashMap<>();
        map.put(source, new GraphNode(source.val));

        while(!queue.isEmpty()){
            GraphNode u = queue.poll();
            GraphNode cloneU = map.get(u);
            if(u.neighbours != null){
                for(GraphNode v: u.neighbours){
                    GraphNode cloneV = map.get(v);
                    if(cloneV == null){
                        queue.add(v);
                        cloneV = new GraphNode(v.val);
                        map.put(v, cloneV);
                    }
                    cloneU.neighbours.add(cloneV);
                }
            }
        }
        return map.get(source);
    }
    static public void bfs(GraphNode source)
    {
        Queue<GraphNode> q = new LinkedList<GraphNode>();
        q.add(source);
        HashMap<GraphNode,Boolean> visit =
                new HashMap<GraphNode,Boolean>();
        visit.put(source,true);
        while (!q.isEmpty())
        {
            GraphNode u = q.poll();
            System.out.println("Value of Node " + u.val);
            System.out.println("Address of Node " + u);
            if (u.neighbours != null)
            {
                LinkedList<GraphNode> v = u.neighbours;
                for (GraphNode g : v)
                {
                    if (visit.get(g) == null)
                    {
                        q.add(g);
                        visit.put(g,true);
                    }
                }
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {
        GraphNode source = buildGraph();
        System.out.println("BFS traversal of a graph before cloning");
        bfs(source);
        GraphNode newSource = cloneGraph(source);
        System.out.println("BFS traversal of a graph after cloning");
        bfs(newSource);
    }
}
