/*
LeetCode Problem No.404:    https://leetcode-cn.com/problems/sum-of-left-leaves/
Author:                     zhangyixing1007
Idea:                       dfs recursion + signal
Time:                       0 ms, beat 100%
Space:                      36.9 MB, beat 46.64%
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
    public int sumOfLeftLeaves(TreeNode root) {
        dfs(root, false);
        return ans;
    }
    int ans=0;
    void dfs(TreeNode root, boolean isLeftNode){
        if(root==null) return;
        if(isLeftNode && root.left==null && root.right==null){
            ans+=root.val;
        }else{
            dfs(root.left, true);
            dfs(root.right, false);
        }
    }
}
