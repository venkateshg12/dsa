import java.util.*;

public class DirectedEulerian {
    private int V; // number of vertices
    private List<List<Integer>> graph;
    private int[] indegree, outdegree;

    public DirectedEulerian(int V) {
        this.V = V;
        graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
        indegree = new int[V];
        outdegree = new int[V];
    }

    // Add directed edge u -> v
    public void addEdge(int u, int v) {
        graph.get(u).add(v);
        outdegree[u]++;
        indegree[v]++;
    }

    // Find Eulerian Path
    public List<Integer> getEulerianPath() {
        int start = 0, end = 0, startNodes = 0, endNodes = 0;

        // Step 1: Check conditions
        for (int i = 0; i < V; i++) {
            if (outdegree[i] - indegree[i] == 1) {
                start = i;
                startNodes++;
            } else if (indegree[i] - outdegree[i] == 1) {
                end = i;
                endNodes++;
            } else if (indegree[i] != outdegree[i]) {
                return null; // not Eulerian
            }
        }

        if (!((startNodes == 1 && endNodes == 1) || (startNodes == 0 && endNodes == 0))) {
            return null; // no Eulerian Path
        }

        // Step 2: If Eulerian Circuit, pick any starting vertex with outgoing edge
        if (startNodes == 0 && endNodes == 0) {
            for (int i = 0; i < V; i++) {
                if (outdegree[i] > 0) {
                    start = i;
                    break;
                }
            }
        }

        // Step 3: Hierholzer’s Algorithm
        Stack<Integer> stack = new Stack<>();
        List<Integer> path = new ArrayList<>();
        stack.push(start);
 
        int[][] edgeCount = new int[V][];
        for (int i = 0; i < V; i++) {
            edgeCount[i] = new int[]{0};
        }

        while (!stack.isEmpty()) {
            int u = stack.peek();
            if (edgeCount[u][0] < graph.get(u).size()) {
                int v = graph.get(u).get(edgeCount[u][0]);
                edgeCount[u][0]++;
                stack.push(v);
            } else {
                path.add(stack.pop());
            }
        }

        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args) {
        // Example Graph
        DirectedEulerian g = new DirectedEulerian(5);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(0, 3);
        g.addEdge(3, 4);

        List<Integer> path = g.getEulerianPath();
        if (path == null) {
            System.out.println("No Eulerian Path exists.");
        } else {
            System.out.println("Eulerian Path: " + path);
        }
    }
}


/* 
Step 1:
stack = [0]
u = 0 → edgeCount[0][0] = 0, graph[0].size() = 2 → still edges left
Take v = graph[0].get(0) = 1
Increment edgeCount[0][0] = 1
Push 1 → stack = [0, 1]

Step 2:
u = 1
edgeCount[1][0] = 0, graph[1].size() = 1 → edge left
v = graph[1].get(0) = 2
edgeCount[1][0] = 1
Push 2 → stack = [0, 1, 2]

Step 3:
u = 2
edgeCount[2][0] = 0, graph[2].size() = 1
v = graph[2].get(0) = 0
edgeCount[2][0] = 1
Push 0 → stack = [0, 1, 2, 0]

Step 4:
u = 0 (the second time we’re here)
edgeCount[0][0] = 1, graph[0].size() = 2 → still edge left
v = graph[0].get(1) = 3
edgeCount[0][0] = 2
Push 3 → stack = [0, 1, 2, 0, 3]

Step 5:
u = 3
edgeCount[3][0] = 0, graph[3].size() = 1
v = graph[3].get(0) = 4
edgeCount[3][0] = 1
Push 4 → stack = [0, 1, 2, 0, 3, 4]

Step 6:
u = 4
edgeCount[4][0] = 0, graph[4].size() = 0 → no edges left
Pop → path = [4], stack = [0, 1, 2, 0, 3]

Step 7:
u = 3
edgeCount[3][0] = 1, graph[3].size() = 1 → no edges left
Pop → path = [4, 3], stack = [0, 1, 2, 0]

Step 8:
u = 0 (second one in stack)
edgeCount[0][0] = 2, graph[0].size() = 2 → no edges left
Pop → path = [4, 3, 0], stack = [0, 1, 2]

Step 9:
u = 2
edgeCount[2][0] = 1, graph[2].size() = 1 → no edges left
Pop → path = [4, 3, 0, 2], stack = [0, 1]

Step 10:
u = 1
edgeCount[1][0] = 1, graph[1].size() = 1 → no edges left
Pop → path = [4, 3, 0, 2, 1], stack = [0]

Step 11:
u = 0 (first one)
edgeCount[0][0] = 2, graph[0].size() = 2 → no edges left
Pop → path = [4, 3, 0, 2, 1, 0], stack = []


 */