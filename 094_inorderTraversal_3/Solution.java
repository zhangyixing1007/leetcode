/*
LeetCode Problem No.94:     https://leetcode.com/problems/binary-tree-inorder-traversal/
Author:                     zhangyixing1007
Idea:                       add and remove new links
Time:                       0 ms, beat 100%
Space:                      37.1 MB, beat 39.83%
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        while(root!=null){
            TreeNode prev=root.left;
            if(prev==null){
                ans.add(root.val); root=root.right; continue;
            }
            while(prev.right!=null&&prev.right!=root){
                prev=prev.right;
            }
            if(prev.right==null){
                prev.right=root;
                root=root.left;
            }
            if(prev.right==root){
                prev.right=null;
                ans.add(root.val);
                root=root.right;
            }
        }
        return ans;
    }
}
