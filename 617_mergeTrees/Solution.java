/*
LeetCode Problem No.617:    https://leetcode.com/problems/merge-two-binary-trees/
Author:                     zhangyixing1007
Idea:                       recursion, tree=root+left-subtree+right-subtree
Time:                       1 ms, beat 99.91%
Space:                      40.3 MB, beat 95.37%
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
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1==null&&t2==null) return null;
        if(t1==null) return t2;
        if(t2==null) return t1;
        t1.val+=t2.val; 
        t1.left=mergeTrees(t1.left,t2.left);
        t1.right=mergeTrees(t1.right, t2.right);
        return t1;
    }
}
