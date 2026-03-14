/* 
Given the root of a binary tree, return the top view of the binary tree.
Top view of a binary tree is the set of nodes visible when the tree is viewed from the top. Return nodes from the leftmost node to the rightmost node. Also if 2 nodes are outside the shadow of the tree and are at the same position then consider the left ones only(i.e. leftmost). 

Example 1 :-
Input : root = [1, 2, 3, 4, 5, 6, 7]
Output : [4, 2, 1, 3, 7]
 */

import java.util.*;
// Definition for a binary tree node.
 class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) { data = val; left = null; right = null; };
}

public class a_02_top_view {

    static class Pair {
        TreeNode node;
        int hd;

        Pair(TreeNode n, int h) {
            node = n;
            hd = h;
        }
    }

    public List<Integer> topView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;

        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(root, 0));

        while (!q.isEmpty()) {

            Pair p = q.poll();
            TreeNode node = p.node;
            int hd = p.hd;

            if (!map.containsKey(hd)) {
                map.put(hd, node.data);
            }

            if (node.left != null) {
                q.offer(new Pair(node.left, hd - 1));
            }

            if (node.right != null) {
                q.offer(new Pair(node.right, hd + 1));
            }
        }

        for (int val : map.values()) {
            ans.add(val);
        }

        return ans;
    }
}