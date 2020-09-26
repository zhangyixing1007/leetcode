/*
LeetCode Problem No.113:    https://leetcode-cn.com/problems/path-sum-ii/
Author:                     zhangyixing1007
Idea:                       dfs, add and remove last
Time:                       1 ms, beat 100%
Space:                      39.5 MB, beat 20.04%
*/

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root==null) return ans;
        pathSum(root,sum,new ArrayList<Integer>());
        return ans;
    }
    List<List<Integer>> ans=new ArrayList<>();
    void pathSum(TreeNode root, int sum, List<Integer> list){
        if(root==null) return;
        sum-=root.val;
        list.add(root.val);
        if(root.left==null&&root.right==null){
            if(sum==0) ans.add(new ArrayList<>(list));
        }else{
            pathSum(root.left, sum, list);
            pathSum(root.right, sum, list);
        }
        list.remove(list.size()-1);
    }
}
