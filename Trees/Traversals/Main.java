import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();
        tree.populate(scanner);
        tree.display();
        
        tree.preOrder();    // Root --> Left --> Right
        tree.inOrder();     // Left --> Root(Parent) --> Right
        tree.postOrder();   // Left --> Right --> Root(Parent)
    }
}
