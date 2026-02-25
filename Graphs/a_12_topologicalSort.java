import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class a_12_topologicalSort {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        int n = 5; 

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(5).add(0);

        adj.get(4).add(0);
        adj.get(4).add(1);

        adj.get(5).add(2);

        adj.get(2).add(3);

        adj.get(3).add(1);
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[n+1];
        for(int i = 1;i <= n;i++) {
            if(!visited[i]) {
                dfs(i,stack,visited,adj);
            }
        }
        int[] ans = new int[n+1];
        int j = 0;
        while(!stack.isEmpty()) {
            ans[j++] = stack.pop();
        }
        System.out.println(Arrays.toString(ans)); 
    }
    public static void dfs(int i, Stack<Integer> stack, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        visited[i] = true;
        for(int adjElement : adj.get(i)) {
            if(!visited[adjElement]) {
                dfs(adjElement,stack,visited,adj);
            }
        }
        stack.push(i);
    }
}
// O(V + E)