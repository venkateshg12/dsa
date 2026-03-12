
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
    private int readInt(Scanner scanner) {
        while(!scanner.hasNextInt()) {
            System.out.println("Invalid input! Please enter the number");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private boolean readBoolean(Scanner scanner) {
        while(!scanner.hasNextBoolean()) {
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
}
