/*
LeetCode Problem No.98:     https://leetcode.com/problems/validate-binary-search-tree/
Author:                     zhangyixing1007
Idea:                       inorder, compare with previous value; stack to keep record
Time:                       3 ms, beat 45.10%
Space:                      36.2 MB, beat 95.66%
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
    public boolean isValidBST(TreeNode root)
    {
        if (root==null) return true;
        TreeNode curr = root;
        Stack<TreeNode> stack = new Stack<>();
        int prev = Integer.MIN_VALUE;
        int now;
        boolean flag = false;
        while(curr!=null||!stack.isEmpty())
        {
            while (curr!=null)
            {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            now = curr.val;
            if (prev>=now&&flag == true) return false;
            prev = now; flag = true;
            curr = curr.right;
        }
        return true;
    }
}
