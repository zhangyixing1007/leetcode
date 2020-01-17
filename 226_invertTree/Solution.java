/*
LeetCode Problem No.226:    https://leetcode.com/problems/invert-binary-tree/
Author:                     zhangyixing1007
Idea:                       recursion
Time:                       0 ms, beat 100%
Space:                      34.3MB, beat 35.04%
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
    public TreeNode invertTree(TreeNode root) {
        if (root==null) return null;
        
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        root.left = invertTree(root.left);
        root.right = invertTree(root.right);
        
        return root;
    }
}
