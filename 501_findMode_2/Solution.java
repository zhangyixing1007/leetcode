/*
LeetCode Problem No.501:    https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/
Author:                     zhangyixing1007
Idea:                       in order transversal, recursion
Time:                       0 ms, beat 100%
Space:                      39.5 MB, beat 60.43%
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
    public int[] findMode(TreeNode root) {
        list=new ArrayList<>();
        if(root==null) return new int[]{};
        dfs(root);
        int[] ans=new int[list.size()];
        for(int i=0; i<list.size(); i++){
            ans[i]=list.get(i);
        }
        return ans;
    }
    List<Integer> list;
    int count=0;
    Integer prev=null;
    int prevCount=0;
    void dfs(TreeNode root){
        if(root==null) return;
        dfs(root.left);
        if(prev==null||root.val!=prev){
            prev=root.val;
            prevCount=1;
        }else{
            prevCount++;
        }
        if(prevCount==count){
            list.add(root.val);
        }else if(prevCount>count){
            count=prevCount;
            list.clear();
            list.add(root.val);
        }
        dfs(root.right);
    }
}
