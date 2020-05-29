/*
LeetCode Problem No.230:    https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/
Author:                     zhangyixing1007
Idea:                       inorder traversal by stack, iteration
Time:                       1 ms, beat 61.55%
Space:                      39.9 MB, beat 8.7%
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
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack=new Stack<>();
        TreeNode curr=root;
        while(!stack.isEmpty()||curr!=null){
            while(curr!=null){
                stack.push(curr);
                curr=curr.left;                
            }
            curr=stack.pop();
            k--;
            if(k==0) break;
            curr=curr.right;
        }
        return curr.val;
    }
}
