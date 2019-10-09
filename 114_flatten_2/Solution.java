/*
LeetCode Problem No.114:    https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
Author:                     zhangyixing1007
Idea:                       recursion, very short version
Time:                       1 ms, beat 99.38%
Space:                      35.7 MB, beat 81.87%
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
    private TreeNode pre = null;
    public void flatten(TreeNode root) 
    {
        if (root==null) return; 
        flatten(root.right);
        flatten(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
    }
}
