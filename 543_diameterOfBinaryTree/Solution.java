/*
LeetCode Problem No.543:    https://leetcode.com/problems/diameter-of-binary-tree/
Author:                     zhangyixing1007
Idea:                       recursion to calculate depth and compare at the same time
Time:                       1 ms, beat 99.85%
Space:                      37.2MB, beat 75.63%
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
    public int diameterOfBinaryTree(TreeNode root) { 
        if (root==null) return 0;         
        len(root); 
        return max; 
    } 
     
    private int max = 0; 
     
    private int len(TreeNode root) 
    { 
        if (root == null) return 0; 
        int l = len(root.left); 
        int r = len(root.right); 
        max = Math.max(max,l+r); 
        return Math.max(l,r)+1; 
    } 
} 
