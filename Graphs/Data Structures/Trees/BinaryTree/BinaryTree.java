
import java.util.Scanner;

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

    // insertion of elements
    public void populate(Scanner scanner) {
        System.out.println("Enter the value of the root: ");
        int value = scanner.nextInt();
        root = new Node(value);
        populate(scanner, root);
    }

    public void populate(Scanner scanner, Node node) {
        System.out.println("Do you want to enter the left of " + node.val);
        boolean left = scanner.nextBoolean();
        if (left) {
            System.out.println("Enter the value to the left of " + node.val);
            int value = scanner.nextInt();
            node.left = new Node(value);
            populate(scanner, node.left);
        }
        System.out.println("Do you want to enter the right of " + node.val);
        boolean right = scanner.nextBoolean();
        if (right) {
            System.out.println("Enter the value to the right of " + node.val);
            int value = scanner.nextInt();
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
        if(level != 0) {
            for(int i = 0;i < level - 1;i++){
                System.out.print("|\t\t");
            }
            System.out.println("|-------> "+node.val);
        }else {
            System.out.println(node.val);
        }
        display(node.left, level + 1);
    }
}
