import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class Info {
  int first;
  int weight;

  Info(int first, int weight) {
    this.first = first;
    this.weight = weight;
  }
}

public class a_14_shortest_path_DAG {
  public static void main(String[] args) {
    int N = 4;
    int M = 2;
    int[][] edge = { { 0, 1, 2 }, { 0, 2, 1 } };
    List<List<Info>> adj = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      adj.add(new ArrayList<>());
    }
    for (int i = 0; i < M; i++) {
      adj.get(edge[i][0]).add(new Info(edge[i][1], edge[i][2]));
    }
    boolean[] visited = new boolean[N];
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < N; i++) {
      if (!visited[i]) {
        dfs(i, stack, visited, adj);
      }
    }
    int[] dist = new int[N];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[0] = 0;
    while (!stack.isEmpty()) {
      int node = stack.pop();
      for (Info n : adj.get(node)) {
        if (dist[n.first] > dist[node] + n.weight) {
          dist[n.first] = dist[node] + n.weight;
        }
      }
    }
    for (int i = 0; i < N; i++) {
      if (dist[i] == Integer.MAX_VALUE) {
        dist[i] = -1;
      }
    }
    System.out.println(Arrays.toString(dist));
  }

  public static void dfs(int i, Stack<Integer> stack, boolean[] visited, List<List<Info>> adj) {
    visited[i] = true;
    for (Info adjElement : adj.get(i)) {
      if (!visited[adjElement.first]) {
        dfs(adjElement.first, stack, visited, adj);
      }
    }
    stack.push(i);
  }
}