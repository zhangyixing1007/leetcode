/*
LeetCode Problem No.0133:   https://leetcode-cn.com/problems/clone-graph/
Author:                     zhangyixing1007
Idea:                       dfs, recusion, HashMap
Time:                       35 ms, beat 97.42%
Space:                      39.1 MB, beat 34.31%
*/

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/
class Solution {
    public Node cloneGraph(Node node) {
        if(node==null || visited.containsKey(node)) return visited.get(node);
        Node curr=new Node(node.val);
        visited.put(node, curr);
        for(Node neighbor:node.neighbors){
            curr.neighbors.add(cloneGraph(neighbor));
        }
        return curr;
    }
    Map<Node, Node> visited=new HashMap<>();
}
