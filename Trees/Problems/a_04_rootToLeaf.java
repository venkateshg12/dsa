import java.util.*;

// Definition for a binary tree node.
class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) { data = val; left = null; right = null; };
}

public class a_04_rootToLeaf {
    public List<List<Integer>> allRootToLeaf(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(root, ans, path);
        return ans;
    }

    public void dfs(TreeNode node, List<List<Integer>> ans, List<Integer> path) {
        if (node == null) {
            return;
        }
        path.add(node.data);
        if (node.left == null && node.right == null) {
            ans.add(new ArrayList<>(path));
        } else {
            dfs(node.left, ans, path);
            dfs(node.right, ans, path);
        }
        path.remove(path.size() - 1);
    }
}