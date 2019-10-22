/*
LeetCode Problem No.337:    https://leetcode.com/problems/house-robber-iii
Author:                     zhangyixing1007
Idea:                       recursion, not any repeated calculation, much faster than Verison 3
Time:                       1 ms, beat 100%
Space:                      38.5 MB, beat 66.12%
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
    public int rob(TreeNode root) {
        int[] ans = robOrNot(root);
        return Math.max(ans[0],ans[1]);    
    }
    
    private int[] robOrNot(TreeNode root){
        int[] ans = new int[2];
        if (root == null) return ans;
        
        int[] left = robOrNot(root.left);
        int[] right = robOrNot(root.right);
        
        ans[0] = Math.max(ans[0],left[1]+right[1]);    
        ans[0] = Math.max(ans[0],left[1]+right[0]);
        ans[0] = Math.max(ans[0],left[0]+right[1]);
        ans[0] = Math.max(ans[0],left[0]+right[0]);
        ans[1] = left[0]+right[0]+root.val;
        
        return ans;
    }
}
