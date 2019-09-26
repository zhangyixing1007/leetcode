/*
LeetCode Problem No.104:    https://leetcode.com/problems/maximum-depth-of-binary-tree/
Author:                     zhangyixing1007
Idea:                       recursion, actually Line 24&25 can be deleted, but then space cost will be a little bit higher
Time:                       1 ms, beat 97.99%
Space:                      36.5MB, beat 66.56%
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
    public int maxDepth(TreeNode root) {
        if (root==null) return 0;
        if ((root.left==null)&&(root.right==null))
            return 1;
        if (root.left==null) return maxDepth(root.right)+1;
        if (root.right==null) return maxDepth(root.left)+1;
        return Math.max(maxDepth(root.left)+1,maxDepth(root.right)+1);
    }
}
