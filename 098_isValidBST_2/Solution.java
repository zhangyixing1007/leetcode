/*
LeetCode Problem No.98:     https://leetcode.com/problems/validate-binary-search-tree/
Author:                     zhangyixing1007
Idea:                       irecursion
Time:                       1 ms, beat 99.45%
Space:                      36.4 MB, beat 95.33%
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
class Solution
{
    public boolean isValidBST(TreeNode root)
    {
        return helper(root,null,null);
    }
    
    private boolean helper(TreeNode node,Integer a, Integer b)
    {
        if (node == null) return true;
        
        if(a!=null&&node.val<=a) return false;
        if(b!=null&&node.val>=b) return false;
        
        if (!helper(node.left,a,node.val)) return false;
        if (!helper(node.right,node.val,b)) return false;
        
        return true;
    }
}
