/* 
Minimum time taken to burn the BT from a given Node

Given a target node data and a root of binary tree. If the target is set on fire, determine the shortest amount of time needed to burn the entire binary tree.
It is known that in 1 second all nodes connected to a given node get burned. That is its left child, right child, and parent.

Example 1:
Input : root = [1, 2, 3, 4, null, 5, 6, null, 7]. target = 1
Output : 3

Explanation : The node with value 1 is set on fire.
In 1st second it burns node 2 and node 3.
In 2nd second it burns nodes 4, 5, 6.
In 3rd second it burns node 7.

*/


import java.util.*;
  // Definition for a binary tree node.
class TreeNode {
      int data;
     TreeNode left;
      TreeNode right;
     TreeNode(int val) { data = val; left = null; right = null; };
  }
 

public class a_05_min_time_to_burn {
    public int timeToBurnTree(TreeNode root, int start) {
        //your code goes here
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        buildParent(root, parent);
        TreeNode target = findNode(root, start);
        Queue<TreeNode> que = new LinkedList<>();
        Set<TreeNode> vis = new HashSet<>();
        que.offer(target);
        vis.add(target);
        int time = 0;
        while(!que.isEmpty()) {
            int len = que.size();
            boolean burned = false;
            for(int i = 0;i < len;i++) {
                TreeNode node = que.poll();
                if(node.left != null && !vis.contains(node.left)) {
                    vis.add(node.left);
                    que.offer(node.left);
                    burned = true;
                }
                if(node.right != null && !vis.contains(node.right)) {
                    vis.add(node.right);
                    que.offer(node.right);
                    burned = true;

                }
                TreeNode p = parent.get(node);
                if(p != null && !vis.contains(p)) {
                    vis.add(p);
                    que.offer(p);
                    burned = true;
                }
            }
            if(burned) time++;
        }
        return time;

    }
    public void buildParent(TreeNode cur, Map<TreeNode, TreeNode> parent) {
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(cur);
        while(!que.isEmpty()) {
            TreeNode node = que.poll();
            if(node.left != null) {
                parent.put(node.left, node);
                que.offer(node.left);
            }

            if(node.right != null) {
                parent.put(node.right, node);
                que.offer(node.right);
            }
        }
    }
    public TreeNode findNode(TreeNode root, int target) {

        if(root == null) return null;

        if(root.data == target) return root;

        TreeNode left = findNode(root.left, target);

        if(left != null) return left;

        return findNode(root.right, target);
    }
}