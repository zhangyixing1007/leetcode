/*
LeetCode Problem No.236:    https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
Author:                     zhangyixing1007
Idea:                       dfs, iteration
Time:                       18 ms, beat 25.93%
Space:                      38.1 MB, beat 21.67%
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode,TreeNode> map = new HashMap<>();
        Deque<TreeNode> stack = new ArrayDeque();
        
        map.put(root,null);
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode t = stack.pop();
            if (t.left!=null) {map.put(t.left,t);stack.push(t.left);}
            if (t.right!=null) {map.put(t.right,t);stack.push(t.right);}            
        }
        
        Set<TreeNode> set = new HashSet<>();
        while (p!=null){
            set.add(p);
            p = map.get(p);
        }
        
        while (!set.contains(q)){
            q = map.get(q);
        }
        return q;
    }
}
