/*
LeetCode Problem No.0133:   https://leetcode-cn.com/problems/clone-graph/
Author:                     zhangyixing1007
Idea:                       bfs, iteration, HashMap
Time:                       36 ms, beat 82.02%
Space:                      39.2 MB, beat 21.42%
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
        if(node==null) return null;
        Queue<Node> q=new LinkedList<>();
        q.add(node);
        Map<Node, Node> visited=new HashMap<>();
        visited.put(node, new Node(node.val));
        while(!q.isEmpty()){
            Node curr=q.poll();
            Node newCurr=visited.get(curr);
            for(Node neighbor:curr.neighbors){
                if(!visited.containsKey(neighbor)){
                    visited.put(neighbor, new Node(neighbor.val));
                    q.add(neighbor);
                }
                newCurr.neighbors.add(visited.get(neighbor));
            }
        }
        return visited.get(node);
    }
}
