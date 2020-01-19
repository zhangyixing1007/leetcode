/*
LeetCode Problem No.105:    https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
Author:                     zhangyixing1007
Idea:                       HashMap, determine recursion sequence
Time:                       3 ms, beat 98.39%
Space:                      35.8 MB, beat 99.76%
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
    public TreeNode buildTree(int[] preorder, int[] inorder){
        this.preorder = preorder;
        this.inorder = inorder;
        for (int i = 0; i < inorder.length; i++) map.put(inorder[i],i);
        return build(0,preorder.length);
    }
    
    private Map<Integer,Integer> map = new HashMap<>();
    private int now = 0;
    private int[] preorder;
    private int[] inorder;
    
    private TreeNode build(int a, int b){
        if (a == b) return null;
        int value = preorder[now++];
        int id = map.get(value);
        TreeNode root = new TreeNode(value);
        root.left = build(a,id);
        root.right = build(id+1,b);
            
        return root;
    }
}
