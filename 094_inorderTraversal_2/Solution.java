/*
LeetCode Problem No.94:     https://leetcode.com/problems/binary-tree-inorder-traversal/
Author:                     zhangyixing1007
Idea:                       recursion, dfs
Time:                       1 ms, beat 73.27%
Space:                      34.6 MB, beat 72.19%
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
    public List<Integer> inorderTraversal(TreeNode root) {
        list=new ArrayList<>();
        dfs(root);
        return list;
    }
    List<Integer> list;
    void dfs(TreeNode root){
        if(root==null) return;       
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }
}
