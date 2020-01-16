/*
LeetCode Problem No.538:    https://leetcode.com/problems/convert-bst-to-greater-tree/
Author:                     zhangyixing1007
Idea:                       dfs, right-root-left, one shared int
Time:                       1 ms, beat 100%
Space:                      37.8MB, beat 96.85%
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
    public TreeNode convertBST(TreeNode root) {
        dfs(root);
        return root;
    }
    int sum = 0;
    void dfs(TreeNode root){
        if (root==null) return;
        dfs(root.right);
        root.val+=sum;
        sum=root.val;
        dfs(root.left);
    }
}
