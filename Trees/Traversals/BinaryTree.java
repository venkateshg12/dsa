
import java.util.*;

import javax.swing.tree.TreeNode;

public class BinaryTree {
    public BinaryTree() {

    }

    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    private Node root;

    private int readInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input! Please enter the number");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private boolean readBoolean(Scanner scanner) {
        while (!scanner.hasNextBoolean()) {
            System.out.println("Invalid Input! Please enter true or false:");
            scanner.next();
        }
        return scanner.nextBoolean();
    }

    // insertion of elements
    public void populate(Scanner scanner) {
        System.out.println("Enter the value of the root: ");
        int value = readInt(scanner);
        root = new Node(value);
        populate(scanner, root);
    }

    public void populate(Scanner scanner, Node node) {
        System.out.println("Do you want to enter the left of " + node.val);
        Boolean left = readBoolean(scanner);
        if (left) {
            System.out.println("Enter the value to the left of: " + node.val);
            int value = readInt(scanner);
            node.left = new Node(value);
            populate(scanner, node.left);
        }
        System.out.println("Do you want to add the node to right of " + node.val + ":");
        Boolean right = readBoolean(scanner);
        if (right) {
            System.out.println("Enter the value to the right of: " + node.val);
            int value = readInt(scanner);
            node.right = new Node(value);
            populate(scanner, node.right);
        }
    }

    public void display() {
        display(root, 0);
    }

    public void display(Node node, int level) {
        if (node == null) {
            return;
        }
        display(node.right, level + 1);
        if (level != 0) {
            for (int i = 0; i < level - 1; i++) {
                System.out.print("|\t\t");
            }
            System.out.println("|-------> " + node.val);
        } else {
            System.out.println(node.val);
        }
        display(node.left, level + 1);
    }

    public void preOrder() {
        System.out.print("PreOrder Traversal: ");
        preOrder(root);
        System.out.println();
    }

    public void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder() {
        System.out.print("InOrder Traversal: ");
        inOrder(root);
        System.out.println();
    }

    public void inOrder(Node node) {
        if (node == null) {
            return;
        }
        preOrder(node.left);
        System.out.print(node.val + " ");
        preOrder(node.right);
    }

    public void postOrder() {
        System.out.print("PostOrder Traversal: ");
        postOrder(root);
        System.out.println();
    }

    public void postOrder(Node node) {
        if (node == null) {
            return;
        }
        preOrder(node.left);
        preOrder(node.right);
        System.out.print(node.val + " ");
    }

    public List<Integer> preorderTraversal() {
        return preorderTraversal(root);
    }

    public List<Integer> preorderTraversal(Node root) {

        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {

            Node node = stack.pop();
            result.add(node.val);

            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return result;
    }

    public List<Integer> inorderTraversal() {
        return inorderTraversal(root);
    }

    public List<Integer> inorderTraversal(Node root) {

        List<Integer> result = new ArrayList<>();
        Stack<Node> stack = new Stack<>();

        Node current = root;

        while (current != null || !stack.isEmpty()) {

            // go to leftmost node
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            // process node
            current = stack.pop();
            result.add(current.val);

            // go right
            current = current.right;
        }

        return result;
    }

    public List<Integer> postorderTraversal() {
        return postorderTraversal(root);
    }

    public List<Integer> postorderTraversal(Node root) {

        List<Integer> result = new ArrayList<>();

        if (root == null)
            return result;

        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();

        stack1.push(root);

        while (!stack1.isEmpty()) {

            Node node = stack1.pop();
            stack2.push(node);

            if (node.left != null) {
                stack1.push(node.left);
            }

            if (node.right != null) {
                stack1.push(node.right);
            }
        }

        while (!stack2.isEmpty()) {
            result.add(stack2.pop().val);
        }

        return result;
    }

    public List<Integer> postorderTraversalWithOneStack() {
        return postorderTraversalWithOneStack(root);
    }

    public List<Integer> postorderTraversalWithOneStack(Node root) {

        List<Integer> result = new ArrayList<>();

        Stack<Node> stack = new Stack<>();
        Node current = root;
        Node lastVisited = null;

        while (current != null || !stack.isEmpty()) {

            // go to leftmost node
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {

                Node peekNode = stack.peek();

                // if right child exists and not processed yet
                if (peekNode.right != null && lastVisited != peekNode.right) {
                    current = peekNode.right;
                } else {
                    result.add(peekNode.val);
                    lastVisited = stack.pop();
                }
            }
        }

        return result;
    }
}