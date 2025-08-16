import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DijkstraWithIndexPriorityQueue {
    private int[] heap; // stores node indices
    private int[] key; // key[node] = current priority/ distance
    private int[] indexMap; // indexMap[node] = position in heap[]
    private int size;
    private final int capacity;

    public DijkstraWithIndexPriorityQueue(int maxNodes) {
        this.capacity = maxNodes;
        this.heap = new int[maxNodes];
        this.key = new int[maxNodes];
        this.indexMap = new int[maxNodes];
        Arrays.fill(key, Integer.MAX_VALUE);
        Arrays.fill(indexMap, -1);
        this.size = 0;
    }

    static class Edge {
        int to;
        int weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
    // insert a node with given key(distance)

    public void insert(int node, int keyValue) {
        if (indexMap[node] != -1) {
            decreaseKey(node, keyValue);
            return;
        }
        heap[size] = node;
        key[node] = keyValue;
        indexMap[node] = size;
        bubbleUp(size);
        size++;
    }

    // update node's key to a lower value
    public void decreaseKey(int node, int newKey) {
        if (newKey >= key[node])
            return;
        key[node] = newKey;
        bubbleUp(indexMap[node]); // restore heap properly
    }

    // remove and return node with minimum key
    public int extractMin() {
        int minNode = heap[0];
        indexMap[minNode] = -1;
        heap[0] = heap[size - 1];
        indexMap[heap[0]] = 0;
        size--;
        bubbleDown(0);
        return minNode;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int parent(int pos) {
        return (pos - 1) / 2;
    }

    private int leftChild(int pos) {
        return 2 * pos + 1;
    }

    private int rightChild(int pos) {
        return 2 * pos + 2;
    }

    private void bubbleUp(int pos) {
        while (pos > 0 && key[heap[pos]] < key[heap[parent(pos)]]) {
            swap(pos, parent(pos));
            pos = parent(pos);
        }
    }

    private void bubbleDown(int pos) {
        int smallest = pos;
        int left = leftChild(pos);
        int right = rightChild(pos);

        if (left < size && key[heap[left]] < key[heap[smallest]]) {
            smallest = left;
        }

        if (right < size && key[heap[right]] < key[heap[smallest]]) {
            smallest = right;
        }

        if (smallest != pos) {
            swap(pos, smallest);
            bubbleDown(smallest);
        }
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
        indexMap[heap[i]] = i;
        indexMap[heap[j]] = j;
    }

    private static int[] dijkstraWithIPQ(List<List<Edge>> graph, int start) {
        int n = graph.size();
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        DijkstraWithIndexPriorityQueue ipq = new DijkstraWithIndexPriorityQueue(n);
        ipq.insert(start, 0);

        while (!ipq.isEmpty()) {
            int u = ipq.extractMin();
            for (Edge e : graph.get(u)) {
                int v = e.to;
                int newDist = dist[u] + e.weight;
                if (newDist < dist[v]) {
                    dist[v] = newDist;
                    if (ipq.indexMap[v] != -1) {
                        ipq.decreaseKey(v, newDist);
                    } else {
                        ipq.insert(v, newDist);
                    }
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        // Example graph (adjacency list)
        int n = 5; // Number of nodes
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Add edges (directed graph)
        graph.get(0).add(new Edge(1, 3));
        graph.get(0).add(new Edge(2, 1));
        graph.get(1).add(new Edge(3, 4));
        graph.get(1).add(new Edge(0, 3));
        graph.get(2).add(new Edge(0, 1));
        graph.get(2).add(new Edge(3, 2));
        graph.get(3).addAll(Arrays.asList(new Edge(1, 4), new Edge(2, 2), new Edge(4, 2), new Edge(5, 1)));

        int start = 0;
        int[] shortestDistances = dijkstraWithIPQ(graph, start);

        System.out.println("Shortest distances from node " + start + ":");
        for (int i = 0; i < n; i++) {
            System.out.println("Node " + i + ": " + shortestDistances[i]);
        }
    }
}