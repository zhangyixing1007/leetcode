/*
LeetCode Problem No.114:    https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
Author:                     zhangyixing1007
Idea:                       recursion, most simple thought
Time:                       1 ms, beat 99.38%
Space:                      36 MB, beat 81.87%
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
    public void flatten(TreeNode root)
    {
        if (root!=null)
        {
            root = flat(root);
        }
    }
    
    private TreeNode flat(TreeNode root)
    {
        if (root==null) return null;
        TreeNode r = root;
        TreeNode right = root.right;
        if (root.left!=null)
        {
            TreeNode left = root.left;
            root.left = null;
            root.right = flat(left);
        }
        else {root.right = flat(right); return root;}
        if (right!=null)
        {
            while (r.right!=null) r = r.right;
            r.right = flat(right);  
        }
        return root;
    }
}
