import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class a_04_bfs {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int n = 9;
        for (int i = 0; i < n + 1; i++) {
            list.add(new ArrayList<>());
        }

        list.get(1).add(2);
        list.get(2).add(1);

        list.get(1).add(6);
        list.get(6).add(1);

        list.get(2).add(3);
        list.get(3).add(2);

        list.get(2).add(4);
        list.get(4).add(2);

        list.get(6).add(7);
        list.get(7).add(6);

        list.get(6).add(9);
        list.get(9).add(6);

        list.get(4).add(5);
        list.get(5).add(4);

        list.get(7).add(8);
        list.get(8).add(7);

        list.get(5).add(8);
        list.get(8).add(5);

        boolean[] visited = new boolean[n + 1];
        ArrayList<Integer> bfs = new ArrayList<>();
        Queue<Integer> que = new ArrayDeque<>(); 
        /* 
        ArrayDeque is faster than LinkedList because it stores elements in contiguous memory 
        and stores only the data,while LinkedList stores each element inside a node object 
        that contains the data along with references to the previous and next nodes.
         */
        // Queue<Integer> que = new LinkedList<>();
        
        que.add(1);
        visited[1] = true;

        while (!que.isEmpty()) {
            Integer node = que.poll();
            bfs.add(node);

            for (int neighbour : list.get(node)) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    que.add(neighbour);
                }
            }
        }
        for (Integer i : bfs) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}

// Time Complexity ---> O(3N)- visited , que, bfs;
// Space Complexity --->O(N) + O(E) -- number of nodes