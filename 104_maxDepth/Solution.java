/*
LeetCode Problem No.104:    https://leetcode.com/problems/maximum-depth-of-binary-tree/
Author:                     zhangyixing1007
Idea:                       one-line recursion
Time:                       0 ms, beat 100%
Space:                      37.7MB, beat 40.29%
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

class Solution {class Solution 
{
    public int maxDepth(TreeNode root) 
    {
        return root==null? 0 : Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
}
