/*
LeetCode Problem No.144:    https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
Author:                     zhangyixing1007
Idea:                       dfs, recursion
Time:                       0 ms, beat 100%
Space:                      37.4 MB, beat 5.25%
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
    public List<Integer> preorderTraversal(TreeNode root) {
        ans=new ArrayList<>();
        preOrder(root);
        return ans;
    }
    List<Integer> ans;
    void preOrder(TreeNode root){
        if(root==null) return;
        ans.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }
}
