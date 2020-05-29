/*
LeetCode Problem No.230:    https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/
Author:                     zhangyixing1007
Idea:                       inorder traversal, recursion
Time:                       0 ms, beat 100%
Space:                      39 MB, beat 8.7%
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
    public int kthSmallest(TreeNode root, int k) {
        this.k=k;
        bfs(root);
        return Kth;
    }
    
    int Kth=0;
    int k;
    
    void bfs(TreeNode root){
        if(root==null) return;
        bfs(root.left);
        if(--k==0) Kth=root.val;
        bfs(root.right);
    }
}
