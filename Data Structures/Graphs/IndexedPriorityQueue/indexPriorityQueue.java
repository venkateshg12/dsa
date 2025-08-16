
import java.util.Arrays;

public class indexPriorityQueue {

    private int[] heap; // stores node indices
    private int[] key; // key[node] = current priority/ distance
    private int[] indexMap; // indexMap[node] = position in heap[]
    private int size;
    private final int capacity;

    public indexPriorityQueue(int maxNodes) {
        this.capacity = maxNodes;
        this.heap = new int[maxNodes];
        this.key = new int[maxNodes];
        this.indexMap = new int[maxNodes];
        Arrays.fill(key, Integer.MAX_VALUE);
        Arrays.fill(indexMap, -1);
        this.size = 0;
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
        if(newKey >= key[node]) return;
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

        if(left < size && key[heap[left]] < key[heap[smallest]]) {
            smallest  = left;
        }

        if(right < size && key[heap[right]] < key[heap[smallest]]) {
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
}
