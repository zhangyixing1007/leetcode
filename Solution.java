/*
LeetCode Problem No.5532:   https://leetcode-cn.com/problems/even-odd-tree/
Author:                     zhangyixing1007
Idea:                       bfs, mark level by boolean
Time:                       13 ms
Space:                      55.2 MB
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
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        boolean flag=true;
        q.add(root);
        Integer prev=null;
        int size=q.size();
        while(!q.isEmpty()){
            prev=null;
            size=q.size();
            while(size-->0){
                TreeNode curr=q.poll();
                if(flag){
                    if((curr.val&1)==0) return false;
                    if(prev!=null&&prev>=curr.val) return false;
                }else{
                    if((curr.val&1)==1) return false;
                    if(prev!=null&&prev<=curr.val) return false;
                }
                prev=curr.val;
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
            flag=!flag;
        }
        return true;
    }
} 
