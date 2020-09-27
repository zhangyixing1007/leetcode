/*
LeetCode Problem No.235:    https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
Author:                     zhangyixing1007
Idea:                       trinary search
Time:                       6 ms, beat 99.70%
Space:                      39.7 MB, beat 36.8%
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==p||root==q) return root;
        if(p.val>q.val){
            TreeNode t=p;
            p=q;
            q=t;
        }
        if(root.val<q.val&&root.val>p.val) return root;
        else if(root.val>q.val) return lowestCommonAncestor(root.left, p, q);
        else return lowestCommonAncestor(root.right, p, q);
    }
}
