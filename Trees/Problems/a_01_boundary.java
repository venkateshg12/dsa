
/* 
Given a root of Binary Tree, perform the boundary traversal of the tree. 
The boundary traversal is the process of visiting the boundary nodes of the binary tree in the anticlockwise direction, starting from the root.
The boundary of a binary tree is the concatenation of the root, the left boundary, the leaves ordered from left-to-right, and the reverse order of the right boundary.
The left boundary is the set of nodes defined by the following:
The root node's left child is in the left boundary. If the root does not have a left child, then the left boundary is empty.
If a node in the left boundary and has a left child, then the left child is in the left boundary.
If a node is in the left boundary, has no left child, but has a right child, then the right child is in the left boundary.
The leftmost leaf is not in the left boundary.
The right boundary is similar to the left boundary, except it is the right side of the root's right subtree. Again, the leaf is not part of the right boundary, and the right boundary is empty if the root does not have a right child.

Example 1:
Input : root = [1, 2, 3, 4, 5, 6, 7, null, null, 8, 9]
Output : [1, 2, 4, 8, 9, 6, 7, 3]
 */

import java.util.*;
 class TreeNode {
     int data;
     TreeNode left;
     TreeNode right;
     TreeNode(int val) { data = val; left = null; right = null; };
 }

public class a_01_boundary {
    public void addLeftBoundary(TreeNode node, List<Integer> ans) {
        TreeNode cur = node.left;
        while(cur != null) {
            if(!isLeaf(cur)) ans.add(cur.data);
            if(cur.left != null) cur = cur.left;
            else cur = cur.right;
        }
    }
    public boolean isLeaf(TreeNode node) {
        if(node.left == null && node.right == null) {
            return true;
        }
        return false;
    }
    public void addRightBoundary(TreeNode node, List<Integer> ans) {
        TreeNode cur = node.right;
        ArrayList<Integer> list = new ArrayList<>();
        while(cur != null) {
            if(!isLeaf(cur)) list.add(cur.data);
            if(cur.right != null) cur = cur.right;
            else cur = cur.left;
        }
        for(int i = list.size() - 1;i >= 0;i--) {
            ans.add(list.get(i));
        }
    }
    public void addLeaves(TreeNode node, List<Integer> ans) {
        if(isLeaf(node)){
            ans.add(node.data);
            return;
        }
        if(node.left != null) addLeaves(node.left, ans);
        if(node.right != null) addLeaves(node.right, ans);
    }

    public List<Integer> boundary(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(isLeaf(root) == false) ans.add(root.data);
        addLeftBoundary(root, ans);
        addLeaves(root,ans);
        addRightBoundary(root,ans);
        // System.out.println(ans.toString());
        return ans;
    }
}