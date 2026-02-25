
public class AVL {
   
    private class Node {
        int value;
        Node left;
        Node right;
        int height;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    private Node root;

    public int height() {
        return height(root);
    }

    private int height(Node node) {
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

    public void insert(int value) {
        root = insert(root, value);
    }

    private Node insert(Node node, int value) {
        if (node == null) {
            node = new Node(value);
            return node;
        }
        if (value < node.value) {
            node.left = insert(node.left, value);
        }
        if (value > node.value) {
            node.right = insert(node.right, value);
        }
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return rotate(node);
    }

    private Node rotate(Node node) {
        int balance = height(node.left) - height(node.right);
        if (balance > 1) { 
            // left heavy
            if (height(node.left.left) - height(node.left.right) > 0) {
                // left left case
                return rightRotate(node);
            }

            if (height(node.left.left) - height(node.left.right) < 0) {
                // left right case
                node.left = leftRotate(node.left);

                return rightRotate(node);
            }
        }
        if (balance < -1) {
            // right heavy
            if (height(node.right.left) - height(node.right.right) < 0) {
                // right right case
                return leftRotate(node);
            }
            if (height(node.right.left) - height(node.right.right) > 0) {
                // right left case
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }
        return node;
    }

    private Node rightRotate(Node p) {
        Node c = p.left;
        Node t = c.right;
        c.right = p;
        p.left = t;
        p.height = Math.max(height(p.left), height(p.right)) + 1;
        c.height = Math.max(height(c.left), height(c.right)) + 1;
        return c;
    }

    private Node leftRotate(Node p) {
        Node c = p.right;
        Node t = c.left;
        // rotate
        c.left = p;
        p.right = t;
        p.height = Math.max(height(p.left), height(p.right)) + 1;
        c.height = Math.max(height(c.left), height(c.right)) + 1;
        return c;
    }

    public void display() {
        display(this.root, "Root Node: ");
    }

    private void display(Node node, String details) {
        if (node == null) {
            return;
        }
        System.out.println(details + node.value);
        display(node.left, "Left child of " + node.value + " : ");
        display(node.right, "Right child of " + node.value + " : ");
    }

    public void delete(int value) {
    root = delete(root, value);
}

private Node delete(Node node, int value) {
    if (node == null)
        return null;

    // Step 1: Normal BST deletion
    if (value < node.value) {
        node.left = delete(node.left, value);
    } else if (value > node.value) {
        node.right = delete(node.right, value);
    } else {
        // Node to delete found

        // Case 1: No child
        if (node.left == null && node.right == null) {
            return null;
        }

        // Case 2: One child
        if (node.left == null) {
            return node.right;
        } else if (node.right == null) {
            return node.left;
        }

        // Case 3: Two children
        Node successor =   findMin(node.right); // smallest in right subtree
        node.value = successor.value; // copy value
        node.right = delete(node.right, successor.value); // delete successor
    }

    // Step 2: Update height
    node.height = Math.max(height(node.left), height(node.right)) + 1;

    // Step 3: Rebalance
    return rotate(node);
}

private Node findMin(Node node) {
    while (node.left != null) {
        node = node.left;
    }
    return node;
}
}