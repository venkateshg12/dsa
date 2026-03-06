import java.util.ArrayList;
import java.util.Stack;

public class a_24_kosarajus_algo {

    private static void dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj, Stack<Integer> st) {

        vis[node] = true;

        for (Integer it : adj.get(node)) {
            if (!vis[it]) {
                dfs(it, vis, adj, st);
            }
        }

        st.push(node);
    }

    private static void dfs3(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adjT, ArrayList<Integer> component) {
        component.add(node);
        vis[node] = true;
        for (Integer it : adjT.get(node)) {
            if (!vis[it]) {
                dfs3(it, vis, adjT, component);
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int V = 8;
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());
        adj.get(1).add(0);
        adj.get(1).add(2);
        adj.get(2).add(0);
        adj.get(2).add(3);
        adj.get(3).add(4);
        adj.get(4).add(5);
        adj.get(5).add(6);
        adj.get(6).add(7);
        adj.get(7).add(4);

        boolean[] vis = new boolean[V];
        Stack<Integer> st = new Stack<>();
        for(int i = 0;i < V;i++) {
            if(!vis[i]) {
                dfs(i, vis,adj, st);
            }
        }

        ArrayList<ArrayList<Integer>> adjT = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adjT.add(new ArrayList<>());
        for (int i = 0; i < V; i++) {
            vis[i] = false;
            for (Integer it : adj.get(i)) {
                adjT.get(it).add(i);
            }
        }
        int scc = 0;
        ArrayList<ArrayList<Integer>> sccList = new ArrayList<>();

while(!st.isEmpty()) {

    int node = st.pop();

    if(!vis[node]) {
        scc++;
        ArrayList<Integer> component = new ArrayList<>();
        dfs3(node, vis, adjT, component);
        sccList.add(component);
    }
}
        System.out.println(scc);
        System.out.println(sccList.toString());
    }
}
