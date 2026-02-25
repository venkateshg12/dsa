import java.util.*;
public class dfs {
    static int n;
    static  List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;

    public static void dfsalgo(int at) {
        if(visited[at]){
            return;
        }
        visited[at] = true;
        System.out.print(at + " ");

        for(int neighbour : graph.get(at)){
            dfsalgo(neighbour);
        }
    }
    public static void main(String[] args) {
        n = 5;
        visited = new boolean[n];
        for(int i  = 0;i < n;i++) {
            graph.add(new ArrayList<>());
        }
        graph.get(0).addAll(Arrays.asList(1,2,3,4));
        graph.get(1).addAll(Arrays.asList(0,2,4));
        graph.get(2).addAll(Arrays.asList(0,1,3));
        graph.get(3).addAll(Arrays.asList(0,2,4));
        graph.get(4).addAll(Arrays.asList(0,1,3));
        dfsalgo(0);
    }
}
