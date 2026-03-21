/* 
Given the root of a binary tree, return true if and only if every node’s value is equal to the sum of the values stored in its left and right children.
For any missing ( null ) child, its value is treated as 0.
A leaf node automatically satisfies the rule because both children are null.

Example 1:
Input: root = [1,4,3,5]
Output: false
Explanation:
The root is 1, but its children sum to 4 + 3 = 7. Since 1 ≠ 7, the tree violates the property.
 */

class TreeNode {     
    int val;
    TreeNode left, right;
    TreeNode(int x) { val = x; };
}

public class a_05_check_child_sum {
    boolean checkChildrenSum(TreeNode root) { 
        // Your code goes here
        if(root == null) return true;
        if(root.left == null && root.right == null) {
            return true;
        }
        int leftVal = 0;
        int rightVal = 0;
        if(root.left != null) {
            leftVal = root.left.val;
        }
        if(root.right != null) {
            rightVal = root.right.val;
        }
        if(root.val != leftVal + rightVal) {
            return false;
        }
        return checkChildrenSum(root.left) && checkChildrenSum(root.right);
    }
}
