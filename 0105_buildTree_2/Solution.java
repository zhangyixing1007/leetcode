/*
LeetCode Problem No.0105:   https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
Author:                     zhangyixing1007
Idea:                       recursion + HashMap
Time:                       3 ms, beat 73.52%
Space:                      39.2 MB, beat 56.43%
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
    Map<Integer, Integer> pos=new HashMap<>();
    int root;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(inorder==null||inorder.length==0) return null;
        for(int i=0; i<inorder.length; i++){
            pos.put(inorder[i], i);
        }
        root=0;
        return buildTree(preorder, inorder, 0, inorder.length-1);
    }
    TreeNode buildTree(int[] preorder, int[] inorder, int l, int r){
        if(l>r) return null;
        TreeNode curr=new TreeNode(preorder[root]);
        int mid=pos.get(preorder[root]);
        root++;
        curr.left=buildTree(preorder, inorder, l, mid-1);
        curr.right=buildTree(preorder, inorder, mid+1, r);
        return curr;
    }
}
