/*
LeetCode Problem No.404:    https://leetcode-cn.com/problems/sum-of-left-leaves/
Author:                     zhangyixing1007
Idea:                       bfs+Queue+Pair
Time:                       1 ms, beat 9.49%
Space:                      37.2 MB, beat 5.27%
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
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null) return 0;
        Queue<Pair<TreeNode, Boolean>> q=new LinkedList<>();
        q.add(new Pair(root,false));
        int ans=0;
        while(!q.isEmpty()){
            Pair<TreeNode, Boolean> curr=q.poll();
            TreeNode key=curr.getKey();
            Boolean value=curr.getValue();
            if(value && key.left==null && key.right==null){
                ans+=key.val;
            }else{
                if(key.left!=null) q.add(new Pair(key.left,true));
                if(key.right!=null) q.add(new Pair(key.right,false));
            }
        }
        return ans;
    }
}
