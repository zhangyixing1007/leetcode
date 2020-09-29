/*
LeetCode Problem No.117:    https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii/
Author:                     zhangyixing1007
Idea:                       bfs+queue
Time:                       3 ms, beat 12.79%
Space:                      38.7 MB, beat 29.40%
*/

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root==null) return root;
        Deque<Node> deque=new ArrayDeque<>();
        deque.addLast(root);
        Node split=new Node(0);
        deque.add(split);
        while(deque.size()!=0){
            Node curr=deque.pollFirst();
            Node next=deque.peekFirst();
            if(curr.left!=null) deque.addLast(curr.left);
            if(curr.right!=null) deque.addLast(curr.right);
            if(next==split){
                curr.next=null;
                deque.pollFirst();
                deque.addLast(split);
            }else{
                curr.next=next;
            }
        }
        return root;
    }
}
