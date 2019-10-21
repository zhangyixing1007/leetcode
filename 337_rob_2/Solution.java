/*
LeetCode Problem No.337:    https://leetcode.com/problems/house-robber-iii
Author:                     zhangyixing1007
Idea:                       recursion, no saving
Time:                       11 ms, beat 53.54%
Space:                      37.9 MB, beat 78.95%
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
    
    private Map<TreeNode,Integer> map = new HashMap<>();
    
    private int rob(TreeNode root, boolean take){
        if (root == null) return 0;
        if(take){
            if(!map.containsKey(root)){
                int sum = root.val + rob(root.left,false) + rob(root.right,false);
                map.put(root,sum);
                return sum;    
            }
            return map.get(root);
        }            
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
