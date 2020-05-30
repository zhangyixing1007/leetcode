/*
LeetCode Problem No.116:    https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/
Author:                     zhangyixing1007
Idea:                       iteration
Time:                       0 ms, beat 100%
Space:                      40 MB, beat 13.3%
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
        Node leftHead=root;
        while(leftHead.left!=null){
            Node head=leftHead;          
            while(head!=null){
                head.left.next=head.right;
                if(head.next!=null) head.right.next=head.next.left;
                head=head.next;
            }
            leftHead=leftHead.left;
        }
        return root;
    }
}
