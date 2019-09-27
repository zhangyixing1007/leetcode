/*
LeetCode Problem No.538:    https://leetcode.com/problems/convert-bst-to-greater-tree/
Author:                     zhangyixing1007
Idea:                       shared private int and interesting recursion
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
        if(root==null) return root; 
        return convert(root); 
    } 
     
    private int sum = 0; 
     
    private TreeNode convert (TreeNode root) 
    { 
        if (root==null) return root; 
         
        root.right = convert(root.right); 
        root.val += sum; 
        sum = root.val; 
        root.left = convert(root.left); 
        return root; 
    } 
} 
