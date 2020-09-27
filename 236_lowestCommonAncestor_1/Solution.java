/*
LeetCode Problem No.236:    https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
Author:                     zhangyixing1007
Idea:                       dfs, recursion
Time:                       9 ms, beat 97.34%
Space:                      35.3 MB, beat 82.06%
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

class Solution{
    TreeNode ancestor = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        dfs(root,p,q);
        return ancestor;
    }
    
    private int dfs(TreeNode root, TreeNode p, TreeNode q){
        if (root==null) return 0;
        int left = dfs(root.left,p,q);
        int right = dfs(root.right,p,q);
        int mid = root == p||root == q? 1:0;
        if (left+right+mid>1) ancestor = root;
        return left+right+mid>0? 1:0;
    }
}
