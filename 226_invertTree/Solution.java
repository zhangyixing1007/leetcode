/*
LeetCode Problem No.226:    https://leetcode.com/problems/invert-binary-tree/
Author:                     zhangyixing1007
Idea:                       recursive
Time:                       1 ms, beat 88.75%
Space:                      35.5MB, beat 32.81%
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
