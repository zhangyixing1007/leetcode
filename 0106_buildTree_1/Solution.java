/*
LeetCode Problem No.0106:   https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
Author:                     zhangyixing1007
Idea:                       recursion 
Time:                       4 ms, beat 44.97%
Space:                      39.1 MB, beat 74.04%
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1);
    }
    TreeNode buildTree(int[] inorder, int[] postorder, int l1, int r1, int l2, int r2){
        if(l1>r1) return null;
        if(l1==r1) return new TreeNode(inorder[l1]);
        TreeNode curr=new TreeNode(postorder[r2]);
        int m=-1;
        for(int i=l1; i<=r1; i++){
            if(inorder[i]==postorder[r2]){
                m=i; break;
            }
        }
        curr.left=buildTree(inorder, postorder, l1, m-1, l2, m-1-l1+l2);
        curr.right=buildTree(inorder, postorder, m+1, r1, m+1-r1+r2-1, r2-1);
        return curr;
    }
}
