/*
LeetCode Problem No.105:    https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
Author:                     zhangyixing1007
Idea:                       recursion, record the start and end index of left/right tree in two arrays
Time:                       16 ms, beat 56.95%
Space:                      42.3 MB, beat 25.05%
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

class Solution
{
    public TreeNode buildTree(int[] preorder, int[] inorder)
    {
        if (preorder.length==0) return null;
        if (preorder.length!=inorder.length) return null;
        
        this.preorder = preorder;
        this.inorder = inorder;
        TreeNode root = build(0,0,preorder.length-1,0,inorder.length-1);
        return root;
    }
    
    private int[] preorder;
    private int[] inorder;
    private TreeNode build(int r, int pa, int pb, int ia, int ib)
    {
        if (ia > ib) return null;
        if (ia == ib) return new TreeNode(preorder[r]);
        for (int i = ia; i <= ib; i++)
        {
            if (preorder[r] == inorder[i])
            {
                TreeNode root = new TreeNode(preorder[r]);
                root.left = build(pa+1,pa+1,pa-ia+i,ia,i-1);
                root.right = build(pb-ib+i+1,pb-ib+i+1,pb,i+1,ib);
                return root;
            }
        }
        return null;
    }
}
