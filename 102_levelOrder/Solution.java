/*
LeetCode Problem No.102:    https://leetcode.com/problems/binary-tree-level-order-traversal/
Author:                     zhangyixing1007
Idea:                       queue to keep record, root to separate each level (actually, an int could do it)
Time:                       2 ms, beat 81.87%
Space:                      36.3 MB, beat 48.09%
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root==null) return list;
        TreeNode curr = root;
        if (root.left!=null) q.add(root.left);
        if (root.right!=null) q.add(root.right);
        q.add(curr);
        List<Integer> first = new ArrayList<>();
        first.add(curr.val);
        list.add(first);
        while (true)
        {
            List<Integer> l = new ArrayList<>();
            while(!q.isEmpty()&&q.peek()!=root)
            {
                curr = q.poll();
                l.add(curr.val);
                if (curr.left!=null) q.add(curr.left);
                if (curr.right!=null) q.add(curr.right);
            }
            if (l.size()!=0) list.add(l);
            if (!q.isEmpty()&&q.peek()==root)
            {
                curr = q.poll();
                if(q.isEmpty()) break;
                else q.add(curr);
            }            
        }
        return list;
    }
}
