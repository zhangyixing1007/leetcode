/*
LeetCode Problem No.337:    https://leetcode.com/problems/house-robber-iii
Author:                     zhangyixing1007
Idea:                       recursion, repeated calculation for rob(root.left.left) and rob(root.left.right), exponential extra cost
Time:                       441 ms, beat 46.57%
Space:                      36 MB, beat 97.70%
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
    
    public int rob(TreeNode root){
        if (root == null) return 0;
        
        int[] ans = new int[2];
        int[] left = new int[2];
        int[] right = new int[2];
        
        if (root.left!=null){
            left[0] = rob(root.left.left) + rob(root.left.right);
            left[1] = rob(root.left);   
        }
        
        if (root.right!=null){
            right[0] = rob(root.right.left) + rob(root.right.right);
            right[1] = rob(root.right);   
        }
        
        
        ans[0] = left[1]+right[1];
        ans[1] = left[0]+right[0]+root.val;
        
        return Math.max(ans[0],ans[1]);
    }
        
}
