/*
LeetCode Problem No.94:     https://leetcode.com/problems/binary-tree-inorder-traversal/
Author:                     zhangyixing1007
Idea:                       queue to keep record
Time:                       1 ms, beat 98.08%
Space:                      34.7 MB, beat 39.65%
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
    public List<Integer> inorderTraversal(TreeNode root) 
    {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
         
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty())
        {
            while (curr!=null)
            {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            list.add(curr.val);
            curr = curr.right;
        }
        return list;
    }
}
