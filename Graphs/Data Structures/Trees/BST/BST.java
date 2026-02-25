// package Trees.BST;

public class BST {
    public BST() {

    }

    private class Node {
        int val;
        Node right;
        Node left;
        int height;

        public Node(int val) {
            this.val = val;
        }

        public int getValue() {
            return val;
        }
    }

    private Node root;

    public int height(Node node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void populate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            this.insert(nums[i]);
        }
    }

    public void populateSort(int[] nums) {
        populateSort(nums, 0, nums.length);
    }

    private void populateSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (end + start) / 2;
        this.insert(nums[mid]);
        populateSort(nums, start, mid);
        populateSort(nums, mid + 1, nums.length);
    }

    public void insert(int value) {
        root = insert(root, value);
    }

    private Node insert(Node node, int value) {
        if (node == null) {
            node = new Node(value);
            return node;
        }
        if (value < node.val) {
            node.left = insert(node.left, value);
        }
        if (value > node.val) {
            node.right = insert(node.right, value);
        }
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return node;
    }

    public void display() {
        display(this.root, "Root Node: ");
    }

    private void display(Node node, String details) {
        if (node == null) {
            return;
        }
        System.out.println(details + node.val);
        display(node.left, "Left child of " + node.val + " : ");
        display(node.right, "Right child of " + node.val + " : ");
    }

    private boolean balanced(Node node) {
        if (node == null) {
            return true;
        }
        return Math.abs(height(node.left) - height(node.right)) <= 1 && balanced(node.left) && balanced(node.right);
    }

    public void preorder() {
        preorder(root);
    }

    private void preorder(Node node) {
        if (node == null) {
            return;
        }
        preorder(node.left);
        System.out.println("left of " + node.val + "  ");
        preorder(node.right);
        System.out.println("right of " + node.val + "  ");
    }

    public void inOrder() {
        inOrder(root);
    }

     private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.val + "  ");
        inOrder(node.right);
    }

    public void postOrder() {
        postOrder(root);
    }
     private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.val + "  ");
        inOrder(node.right);
    }
}
