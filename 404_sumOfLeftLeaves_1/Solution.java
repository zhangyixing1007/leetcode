/*
LeetCode Problem No.404:    https://leetcode-cn.com/problems/sum-of-left-leaves/
Author:                     zhangyixing1007
Idea:                       dfs recursion
Time:                       0 ms, beat 100%
Space:                      36.7 MB, beat 70%
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
        dfs(root);
        return ans;
    }
    int ans=0;
    void dfs(TreeNode root){
        if(root==null) return;
        if(root.left!=null){
            if(root.left.left==null&&root.left.right==null) ans+=root.left.val;
            else dfs(root.left);
        }
        dfs(root.right);
    }
}
