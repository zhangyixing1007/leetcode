/*
LeetCode Problem No.0106:   https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
Author:                     zhangyixing1007
Idea:                       recursion + HashMap
Time:                       2 ms, beat 97.87%
Space:                      39.4 MB, beat 31.46%
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder==null||inorder.length==0) return null;
        for(int i=0; i<inorder.length; i++){
            pos.put(inorder[i], i);
        }
        root=postorder.length;
        return buildTree(inorder, postorder, 0, inorder.length-1);
    }
    TreeNode buildTree(int[] inorder, int[] postorder, int l, int r){
        if(l>r) return null;
        root--;
        TreeNode curr=new TreeNode(postorder[root]);
        int mid=pos.get(postorder[root]);
        curr.right=buildTree(inorder, postorder, mid+1, r);
        curr.left=buildTree(inorder, postorder, l, mid-1);
        return curr;
    }
}
