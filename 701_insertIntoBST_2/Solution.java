/*
LeetCode Problem No.701:    https://leetcode-cn.com/problems/insert-into-a-binary-search-tree/
Author:                     zhangyixing1007
Idea:                       iteration
Time:                       0 ms, beat 100%
Space:                      39.7 MB, beat 13.68%
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
        TreeNode curr=root;
        while(true){
            if(curr.val<val){
                if(curr.right==null){
                    curr.right=new TreeNode(val);
                    break;
                }else{
                    curr=curr.right;
                }
            }else{
                if(curr.left==null){
                    curr.left=new TreeNode(val);
                    break;
                }else{
                    curr=curr.left;
                }
            }
        }
        return root;
    }
}
