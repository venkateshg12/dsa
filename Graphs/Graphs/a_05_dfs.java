import java.util.ArrayList;

public class a_05_dfs {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int n = 8;
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        list.get(1).add(2);
        list.get(2).add(1);

        list.get(1).add(3);
        list.get(3).add(1);

        list.get(2).add(5);
        list.get(5).add(2);

        list.get(2).add(6);
        list.get(6).add(2);
        
        list.get(3).add(7);
        list.get(7).add(3);

        list.get(3).add(4);
        list.get(4).add(3);


        list.get(4).add(8);
        list.get(8).add(4);

        list.get(7).add(8);
        list.get(8).add(7);
        
        boolean [] visited = new boolean[n + 1];
        ArrayList<Integer> ls = new ArrayList<>();
        dfs(1,list,visited, ls);
        for(int i : ls) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    public static void dfs(int node, ArrayList<ArrayList<Integer>> list, boolean[] visited, ArrayList<Integer> ls) {
        visited[node] = true;
        ls.add(node);
        // System.out.print(node+" ");
        for(int n : list.get(node)) {
            if(!visited[n]) {
                dfs(n, list, visited,ls);
            }
        }
    }

}
// Space Complexity ---> O(3N) -- ls, visited,recursion(stack space)
// Time Complexity ---> O(N)+ O(2E)