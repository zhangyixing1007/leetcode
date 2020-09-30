/*
LeetCode Problem No.701:    https://leetcode-cn.com/problems/insert-into-a-binary-search-tree/
Author:                     zhangyixing1007
Idea:                       recursion
Time:                       0 ms, beat 100%
Space:                      39.4 MB, beat 65.69%
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null) return new TreeNode(val);
        if(root.val<val) root.right=insertIntoBST(root.right, val);
        else root.left=insertIntoBST(root.left, val);
        return root;
    }
}
