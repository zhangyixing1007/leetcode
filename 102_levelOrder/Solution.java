/*
LeetCode Problem No.102:    https://leetcode.com/problems/binary-tree-level-order-traversal/
Author:                     zhangyixing1007
Idea:                       queue to keep record, root to separate each level (actually, an int could do it)
Time:                       1 ms, beat 98.79%
Space:                      36.1 MB, beat 92.5%
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
        List<List<Integer>> list=new ArrayList<>();
        if (root==null) return list;
        
        Queue<TreeNode> q=new LinkedList<>();
        List<Integer> l=new ArrayList<>(); 
        l.add(root.val);list.add(l);
        if (root.left!=null) q.add(root.left);
        if (root.right!=null) q.add(root.right);  
        q.add(root);
        l=new ArrayList<>();
        while (!q.isEmpty()){
            TreeNode curr=q.poll();
            if (curr==root){
                if (l.size()!=0) list.add(l);
                l=new ArrayList<>();
                if (q.isEmpty()) break;
                else {
                    q.add(root);
                    curr=q.poll();                    
                }
            }
            l.add(curr.val);
            if (curr.left!=null) q.add(curr.left);
            if (curr.right!=null) q.add(curr.right);
        }
        return list;           
    }
}
