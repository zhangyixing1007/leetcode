/*
LeetCode Problem No.144:    https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
Author:                     zhangyixing1007
Idea:                       dfs, iteration
Time:                       0 ms, beat 100%
Space:                      36.9 MB, beat 77.01%
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
        List<Integer> ans=new ArrayList<>();
        if(root==null) return ans;
        Deque<TreeNode> stack=new ArrayDeque<>();
        stack.addLast(root);
        while(!stack.isEmpty()){
            TreeNode curr=stack.pollLast();
            ans.add(curr.val);
            if(curr.right!=null) stack.addLast(curr.right);
            if(curr.left!=null) stack.addLast(curr.left);
        }
        return ans;
    }
}
