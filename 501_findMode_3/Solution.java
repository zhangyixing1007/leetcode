/*
LeetCode Problem No.501:    https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/
Author:                     zhangyixing1007
Idea:                       in order transversal, Morris
Time:                       2 ms, beat 54.06%
Space:                      39.2 MB, beat 95.79%
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
        while(root!=null){
            prev=root.left;
            if(prev==null) {
                helper(root); root=root.right; continue;
            }
            while(prev.right!=null&&prev.right!=root){
                prev=prev.right;
            }
            if(prev.right==null){
                prev.right=root;
                root=root.left;
            }
            if(prev.right==root){
                prev.right=null;
                helper(root);
                root=root.right;
            }
        }
        int[] ans=new int[list.size()];
        for(int i=0; i<list.size(); i++){
            ans[i]=list.get(i);
        }
        return ans;
    }
    List<Integer> list=new ArrayList<>();
    Integer prevValue=null;
    int prevCount=0;
    int maxCount=0;
    TreeNode prev=null;
    void helper(TreeNode root){
        if(prevValue==null||prevValue!=root.val){
            prevValue=root.val;
            prevCount=1;
        }else{
            prevCount++;
        }
        if(maxCount<prevCount){
            maxCount=prevCount;
            list.clear();
            list.add(root.val);
        }else if(maxCount==prevCount){
            list.add(root.val);
        }
    }
}
