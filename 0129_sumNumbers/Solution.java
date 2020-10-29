/*
LeetCode Problem No.0129:   https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/
Author:                     zhangyixing1007
Idea:                       dfs
Time:                       0 ms, beat 100%
Space:                      37.3 MB, beat 5.55%
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
    int ans=0;
    public int sumNumbers(TreeNode root) {
        if(root==null) return 0;
        dfs(root,0);
        return ans;
    }
    void dfs(TreeNode root, int val){
        val=10*val+root.val;
        if(root.left==null&&root.right==null){
            ans+=val; return;
        }
        if(root.left!=null) dfs(root.left,val);
        if(root.right!=null) dfs(root.right,val);
    }
}
