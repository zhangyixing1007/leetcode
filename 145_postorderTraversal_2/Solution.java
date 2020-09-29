/*
LeetCode Problem No.145:    https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
Author:                     zhangyixing1007
Idea:                       dfs, iteration
Time:                       1 ms, beat 58.06%
Space:                      36.8 MB, beat 93.86%
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
        List<Integer> ans=new ArrayList<>();
        if(root==null) return ans;
        Deque<TreeNode> stack=new ArrayDeque<>();
        stack.addLast(root);
        while(!stack.isEmpty()){
            TreeNode curr=stack.pollLast();
            ans.add(curr.val);
            if(curr.left!=null) stack.addLast(curr.left);
            if(curr.right!=null) stack.addLast(curr.right);
        }
        Collections.reverse(ans);
        return ans;
    }
}
