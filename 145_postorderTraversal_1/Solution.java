/*
LeetCode Problem No.145:    https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
Author:                     zhangyixing1007
Idea:                       dfs, recursion
Time:                       0 ms, beat 100%
Space:                      39.4 MB, beat 5.09%
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
    public List<Integer> postorderTraversal(TreeNode root) {
        ans=new ArrayList<>();
        postOrder(root);
        return ans;
    }
    List<Integer> ans;
    void postOrder(TreeNode root){
        if(root==null) return;
        postOrder(root.left);
        postOrder(root.right);
        ans.add(root.val);
    }
}
