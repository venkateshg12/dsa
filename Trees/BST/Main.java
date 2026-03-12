public class Main {
    public static void main(String[] args) {
        BST tree = new BST();
        // int[] nums = { 12, 7, 45, 56, 3, 2, 34, 56 };
        // tree.populate(new int[] { 12, 7, 45, 56, 3, 2, 34, 56 });
        tree.populateSort(new int[] { 3, 6, 7, 8, 9, 12, 16, 21 });
        // tree.display();
        // tree.inOrder();
        tree.postOrder();
    }
}
