
// Inorder successor and predecessor in BST

/* Given the root node of a binary search tree (BST) and an integer key. Return the Inorder predecessor and successor of the given key from the provided BST.
Note: key will always present in given BST.
If predecessor or successor is missing then return -1.

Example 1:
Input : root = [5, 2, 10, 1, 4, 7, 12] , key = 10
Output : [7, 12] 
*/

import java.util.Arrays;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int data;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int val) { data = val; left = null, right = null }
 * }
 **/

public class a_09_bst_inord_suc_pre {
    List<Integer> succPredBST(TreeNode root, int key) {
        int pre = -1;
        int suc = -1;
        TreeNode curr = root;
        while(curr != null) {
            if(curr.data < key) {
                pre = curr.data;
                curr = curr.right;
            }else {
                curr = curr.left;
            }
        }
            curr = root;
            while(curr != null) {
                if(curr.data > key) {
                    suc = curr.data;
                    curr = curr.left;
                }else {
                    curr = curr.right;
                }
            }
            return Arrays.asList(pre, suc);

    }
}
