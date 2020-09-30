/*
LeetCode Problem No.501:    https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/
Author:                     zhangyixing1007
Idea:                       brute force
Time:                       9 ms, beat 12.36%
Space:                      40.7 MB, beat 12.49%
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
        map=new HashMap<>();
        dfs(root);
        List<Integer> list=new ArrayList<>();
        int count=0;
        for(int i:map.keySet()){
            if(map.get(i)>count){
                count=map.get(i);
            }
        }
        for(int i:map.keySet()){
            if(map.get(i)==count){
                list.add(i);
            }
        }
        int[] ans=new int[list.size()];
        for(int i=0; i<list.size(); i++){
            ans[i]=list.get(i);
        }
        return ans;
    }
    Map<Integer, Integer> map;
    void dfs(TreeNode root){
        if(root==null) return;
        map.put(root.val, map.getOrDefault(root.val, 0)+1);
        dfs(root.left);
        dfs(root.right);
    }
}
