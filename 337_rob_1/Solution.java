/*
LeetCode Problem No.337:    https://leetcode.com/problems/house-robber-iii
Author:                     zhangyixing1007
Idea:                       recursion, no saving
Time:                       1371 ms, beat 5.02%
Space:                      41.3 MB, beat 15.8%
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
        if (root == null) return 0;
        
        return Math.max(rob(root,true),rob(root,false));
        
    }
    
    private int rob(TreeNode root, boolean take){
        if (root == null) return 0;
        if(take)
            return root.val + rob(root.left,false) + rob(root.right,false);
        else {
            int ans = Integer.MIN_VALUE;
            
            int left_true = rob(root.left,true);
            int left_false = rob(root.left,false);
            int right_true = rob(root.right,true);
            int right_false = rob(root.right,false);
            
            ans = Math.max(ans,left_true + right_true);
            ans = Math.max(ans,left_false + right_true);
            ans = Math.max(ans,left_true + right_false);
            ans = Math.max(ans,left_false + right_false);

            return ans;
        }    
        
    }
}
