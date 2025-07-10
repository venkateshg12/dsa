
public class Main {
    public static void main(String[] args) {   
        AVL tree = new AVL();
        // tree.populate(new int[] {3, 5, 4, 8, 23 ,12 ,1 ,2});
        for(int i = 1;i < 1000;i++) {
            tree.insert(i);
        }
        tree.display();
        System.out.println(tree.height());
    }
}
