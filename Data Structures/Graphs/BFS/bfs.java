import java.util.*;

public class bfs {
    static int n;
    static List<List<Integer>> graph;

    public static void main(String[] args) {
        n = 11;
        graph = new ArrayList<>();
        for(int i = 0;i < n;i++){
            graph.add(new ArrayList<>());
        }
        graph.get(0).addAll(Arrays.asList(1,2));
        graph.get(1).addAll(Arrays.asList(0,3));
        graph.get(2).addAll(Arrays.asList(0,3));
        graph.get(3).addAll(Arrays.asList(1,2,4));
        graph.get(4).addAll(Arrays.asList(3,5,7,9));
        graph.get(5).addAll(Arrays.asList(4,6));
        graph.get(6).addAll(Arrays.asList(5,7));
        graph.get(7).addAll(Arrays.asList(4,6,8,10));
        graph.get(8).addAll(Arrays.asList(7,9));
        graph.get(9).addAll(Arrays.asList(4,8));
        graph.get(10).addAll(Arrays.asList(7));
        List<Integer>path = bfsPath(0, 10);
        System.out.println(new ArrayList<>(path));
    }
    public static  List<Integer> bfsPath(int s , int e) {
        int [] prev = solve(s);
        return reconstructPath(s,e,prev);
    }
    public static List<Integer> reconstructPath(int s, int e, int[] prev) {
        List<Integer> path = new ArrayList<>();
        for(int at = e; at != -1;at = prev[at]) {
            path.add(at);
        }
        Collections.reverse(path);
        if(path.get(0) == s) {
            return path;
        }
        return new ArrayList<>();

    }
    public static int[] solve(int s) {
        boolean [] visited = new boolean[n];
        int[] prev = new int[n];
        Arrays.fill(prev, -1);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = true;

        while(!queue.isEmpty()) {
            int node = queue.poll();
            for(int neighbour : graph.get(node)){
                if(!visited[neighbour]){
                    queue.add(neighbour);
                    visited[neighbour] = true;
                    prev[neighbour] = node;
                }
            }
        }
        return prev; 
    }
}
