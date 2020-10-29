/*
LeetCode Problem No.0116:   https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/
Author:                     zhangyixing1007
Idea:                       use new links
Time:                       0 ms, beat 100%
Space:                      39 MB, beat 21.00%
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
        if(root==null || root.left==null) return root;
        Node head=root; Node newHead=root.left;
        while(head!=null && newHead!=null){
            while(head!=null){
                head.left.next=head.right;
                head.right.next=head.next==null? null:head.next.left;
                head=head.next;
            }
            head=newHead; newHead=head.left;
        }
        return root;
    }
}
