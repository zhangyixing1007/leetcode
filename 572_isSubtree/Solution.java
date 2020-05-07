/*
LeetCode Problem No.572:    https://leetcode-cn.com/problems/subtree-of-another-tree/
Author:                     zhangyixing1007
Idea:                       recursion
Time:                       7 ms, beat 93.76%
Space:                      40.3 MB, beat 40%
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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s!=null&&t==null) return false;
        if(compare(s,t)) return true;
        if(s!=null&&isSubtree(s.left,t)) return true;   
        if(s!=null&&isSubtree(s.right,t)) return true; 
        return false;
    }

    public boolean compare(TreeNode s, TreeNode t){
        if(s==null&&t==null) return true;
        if(s==null||t==null) return false;
        if(s.val!=t.val) return false;
        return compare(s.left,t.left)&&compare(s.right,t.right);            
    }    
}
