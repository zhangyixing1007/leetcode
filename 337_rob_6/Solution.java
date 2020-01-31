/*
LeetCode Problem No.337:    https://leetcode.com/problems/house-robber-iii
Author:                     zhangyixing1007
Idea:                       self recursion, HashMap recording
Time:                       4 ms, beat 57.23%
Space:                      40.9 MB, beat 13.03%
*/

class Solution {
    public int rob(TreeNode root) {
        if(root==null) return 0;
        if(map.containsKey(root)){
            return map.get(root);
        }
        int value=0;
        if(root.left==null&&root.right==null){
            value=Math.max(root.val, 0);
        } else if(root.left==null){
            value=Math.max(root.val+rob(root.right.left)
                               +rob(root.right.right), 
                               rob(root.right));            
        } else if(root.right==null){
            value=Math.max(root.val+rob(root.left.left)
                           +rob(root.left.right), 
                           rob(root.left));
        } else {
            value=Math.max(rob(root.left)+rob(root.right), 
                        root.val+rob(root.left.left)+rob(root.left.right)
                       +rob(root.right.left)+rob(root.right.right));
        }
            map.put(root,value);
            return value;        
    }
    HashMap<TreeNode, Integer> map=new HashMap<>();
}
