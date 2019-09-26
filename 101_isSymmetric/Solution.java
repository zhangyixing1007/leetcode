/*
LeetCode Problem No.101:    https://leetcode.com/problems/symmetric-tree/
Author:                     zhangyixing1007
Idea:                       recursion
Time:                       1 ms, beat 99.31%
Space:                      37.5MB, beat 68.40%
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return checkChildren (root.left,root.right);
    }
    
    private boolean checkChildren (TreeNode left, TreeNode right)
    {
        if ((left!=null && right!=null)==false) return (left==null && right == null);            
        if (left.val != right.val) return false;
        return (checkChildren(left.left,right.right) && checkChildren(left.right,right.left));
    }
}
