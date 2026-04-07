import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Given a root of binary search tree and a key(node) value, find the floor and ceil value 
for that particular key value.

Floor Value Node: Node with the greatest data lesser than or equal to the key value. 
Ceil Value Node: Node with the smallest data larger than or equal to the key value.
If a particular floor or ceil value is not present then output -1.

Example-1:
Input : root = [8, 4, 12, 2, 6, 10, 14] , key = 11
Output : [10, 12]
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int data;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int val) { data = val; left = null, right = null }
 * }
 **/

public class a_08_bst_floor_ceil {
    private List<Integer> list;
    public static void main(String[] args) {
        
    }

    public List<Integer> floorCeilOfBST(TreeNode root, int key) {
        //your code goes here
        list = new ArrayList<>();
        list.add(-1);
        list.add(-1);
        ways(root,key);
        return list;
    }
    public void ways(TreeNode root, int key) {
        if(root == null) {
            return;
        }
        if((root.data <= key) && (list.get(0) == -1 || (key - root.data) < (key - list.get(0)))) {
            list.set(0,root.data);
        }

         if((root.data >= key) && (list.get(1) == -1 ||(root.data - key) <= (list.get(1) - key))) {
            list.set(1,root.data);
        }
        ways(root.left,key);
        ways(root.right,key);
    }
}

// Alternate optimized method.
class Solution {
    public List<Integer> floorCeilOfBST(TreeNode root, int key) {
        //your code goes here
        int floor = -1;
        int ceil = -1;
        while( root != null) {
            if(root.data == key) {
                floor = key;
                ceil = key;
                break;
            }else if (root.data < key) {
                floor = root.data;
                root = root.right;
            }else {
                ceil = root.data;
                root = root.left;
            }
        }
        return Arrays.asList(floor,ceil);
    }
}