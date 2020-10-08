/*
LeetCode Problem No.0105:   https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
Author:                     zhangyixing1007
Idea:                       recursion, record the start and end index of left/right tree in two arrays
Time:                       20 ms, beat 16.03%
Space:                      42.6 MB, beat 23.74%
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.pre=preorder;
        this.in=inorder;
        int len=preorder.length;
        return builder(0, len, 0, len);
    }
    int[] pre;
    int[] in;
    TreeNode builder(int p1, int p2, int o1, int o2){
        if (p1==p2) return null;
        if (p1+1==p2) return new TreeNode(pre[p1]);
        TreeNode root=new TreeNode(pre[p1]);
        int l=-1;
        for(int i=o1; i<o2; i++){
            if (pre[p1]==in[i]){
                l=i; break;
            }
        }
        root.left=builder(p1+1, l-o1+p1+1, o1, l);
        root.right=builder(l+1-o2+p2, p2, l+1, o2);
        return root;
    }
}
