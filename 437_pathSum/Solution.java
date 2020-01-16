/*
LeetCode Problem No.437:    https://leetcode.com/problems/path-sum-iii/
Author:                     zhangyixing1007
Idea:                       tree = root+left-subtree+right-subtree
Time:                       19 ms, beat 58.67%
Space:                      39.8MB, beat 60.16%
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
    public int pathSum(TreeNode root, int sum) {
        if (root==null) return 0;
        return p(root,sum)+pathSum(root.left,sum)+pathSum(root.right,sum);
    }
    int p(TreeNode root, int sum){
        if (root==null) return 0;
        int ans = 0;
        if (sum==root.val) ans++;
        ans+=p(root.left, sum-root.val);
        ans+=p(root.right, sum-root.val); 
        return ans;
    }
}
