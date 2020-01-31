/*
LeetCode Problem No.337:    https://leetcode.com/problems/house-robber-iii
Author:                     zhangyixing1007
Idea:                       recursion, based on Version 4, simply calculation for ans[0];
Time:                       1 ms, beat 100%
Space:                      36.4 MB, beat 96.71%
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
        int[] ans=robOrNot(root);
        return Math.max(ans[0], ans[1]);
    }
    int[] robOrNot(TreeNode root){
        int[] ans=new int[2];
        if (root==null) return ans;
        int[] left=robOrNot(root.left);
        int[] right=robOrNot(root.right);           
        ans[0]=Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        ans[1]=root.val+left[0]+right[0];
        return ans;
    }
}
