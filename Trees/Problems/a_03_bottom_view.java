import java.util.*;
  // Definition for a binary tree node.
class TreeNode {
      int data;
      TreeNode left;
      TreeNode right;
      TreeNode(int val) { data = val; left = null; right = null; };
  }


public class a_03_bottom_view {
    static class Pair {
        TreeNode node;
        int hd;
        Pair(TreeNode node,int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public List<Integer> bottomView(TreeNode root) {
        //your code goes here
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> que = new LinkedList<>();
        que.offer(new Pair(root,0));
        while(!que.isEmpty()) {
            Pair p = que.poll();
            TreeNode node = p.node;
            int hd = p.hd;
            map.put(hd, node.data);
            if(node.left != null) {
                que.offer(new Pair(node.left,hd-1));
            }
            if(node.right != null) {
                que.offer(new Pair(node.right, hd+1));
            }
        }
        for(int val : map.values()) {
            ans.add(val);
        }
        return ans;
    }
}

