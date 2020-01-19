/*
LeetCode Problem No.114:    https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
Author:                     zhangyixing1007
Idea:                       recursion, most simple thought
Time:                       1 ms, beat 99.38%
Space:                      36 MB, beat 81.87%
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
    public void flatten(TreeNode root) {
        dfs(root);
    }
    TreeNode dfs(TreeNode root){
        if (root==null) return null;
        if (root.left==null&&root.right==null) return root;
        TreeNode tmp=root.right;
        root.right=dfs(root.left);
        root.left=null;
        TreeNode curr=root;
        while (curr!=null&&curr.right!=null) curr=curr.right;
        curr.right=dfs(tmp);
        return root;
    }
}
