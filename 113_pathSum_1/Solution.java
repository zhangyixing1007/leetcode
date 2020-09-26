/*
LeetCode Problem No.113:    https://leetcode-cn.com/problems/path-sum-ii/
Author:                     zhangyixing1007
Idea:                       dfs, new ArrayList<>() each time
Time:                       3 ms, beat 17.98%
Space:                      42.9 MB, beat 5.26%
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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root==null) return ans;
        pathSum(root,sum,new ArrayList<Integer>());
        return ans;
    }
    List<List<Integer>> ans=new ArrayList<>();
    void pathSum(TreeNode root, int sum, List<Integer> list){
        sum-=root.val;
        list.add(root.val);
        if(root.left==null&&root.right==null){
            if(sum==0) ans.add(list);
            return;
        }
        if(root.left!=null) pathSum(root.left, sum, new ArrayList<Integer>(list));
        if(root.right!=null) pathSum(root.right, sum, new ArrayList<Integer>(list));
    }
}
